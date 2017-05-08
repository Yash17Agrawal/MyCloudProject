/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import EntityBeans.TransactionTable;
import EntityBeans.Userdata;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author code_eagle
 */
@Stateless
public class TransactionTableFacade extends AbstractFacade<TransactionTable> implements TransactionTableFacadeLocal {

    @PersistenceContext(unitName = "MyCloudProject-ejbPU")
    private EntityManager em;
    @EJB 
    UserdataFacadeLocal obj;
    @EJB
    AccountsFacadeLocal accobj;
    
     /*@Temporal(TemporalType.TIMESTAMP)
    private java.util.Date myDate;*/
     
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransactionTableFacade() {
        super(TransactionTable.class);
    }

    @Override
    public int transact(int userIdFrom, int userIdTo, double amt) {
    
        
        boolean loancheck;
        if(userIdFrom == -1)
            loancheck=true;
        else
            loancheck=checkuserid(userIdFrom);
    if((loancheck) && (checkuserid(userIdTo)) && (amt !=0.0 ||String.valueOf(amt) !=null))
    { double temp_amoiunt = 0;
        if(userIdFrom==-1)
        {
            temp_amoiunt = amt + 10000;
        }
        else
        {
            temp_amoiunt = accobj.getAmount(userIdFrom);
        }
    if (temp_amoiunt-amt>=0)
    {
    TransactionTable tb=new TransactionTable();
    System.out.println("my details "+userIdFrom+"  "+userIdTo+"  "+amt);
    tb.setUserIdFrom(userIdFrom);
    tb.setUserIdTo(userIdTo);
    tb.setCurrentStatus("success");
    java.util.Date dt = new java.util.Date();
    /*java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String currentTime = sdf.format(dt);*/
    tb.setDateTime(dt);
    tb.setAmount(amt);
    tb.setPaymentMode("online");
    create(tb);
   return 1;
}
    }
       return 0;
    
    }
    boolean checkuserid(int id)
    {
        
        ArrayList<Userdata> userlist=obj.getAllusers();
        for(Userdata temp:userlist)
        {
            if(id == temp.getUserId())
                return true;
        }
     return false;   
    }
    public int getTotalentries()
    {
        return count();
    }
    @Override
     public ArrayList<ArrayList<String>> trasactionHistory(int account_id)
    {
        ArrayList<TransactionTable> transactionlist=new ArrayList(findAll());
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<String> temp = new ArrayList();
        for(TransactionTable obj:transactionlist)
        {
            temp.clear();
            if(account_id == obj.getUserIdFrom() || account_id == obj.getUserIdTo())
            {   
                
                temp.add(obj.getTransactionId().toString());
                //temp.add(obj.getDateTime().toString());
                temp.add(obj.getUserIdFrom().toString());
                temp.add(obj.getUserIdTo().toString());
                temp.add(obj.getAmount().toString());
                System.out.println("here" + temp);
                result.add(new ArrayList<>(temp));   
            }
        }
        System.out.println("final result " + result); 
        return result;
    }
}
