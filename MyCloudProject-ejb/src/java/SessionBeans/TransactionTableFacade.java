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
    
    if((checkuserid(userIdFrom) ) && (checkuserid(userIdTo))&&(String.valueOf(userIdFrom) != null || userIdFrom != 0) && (String.valueOf(userIdTo)!=null ||userIdTo !=0) && (amt !=0.0 ||String.valueOf(amt) !=null))
    {
    TransactionTable tb=new TransactionTable();
    System.out.println("my details "+userIdFrom+"  "+userIdTo+"  "+amt);
    tb.setUserIdFrom(userIdFrom);
    tb.setUserIdTo(userIdTo);
    tb.setCurrentStatus("success");
    tb.setDateTime(null);
    tb.setAmount(amt);
    tb.setPaymentMode("online");
   /* boolean flag_useridFrom=false,flag_useridTo=false;
    UserdataFacadeLocal obj=em.getReference(UserdataFacade.class, 1);
    ArrayList<Userdata> userlist=new ArrayList(obj.findAll());
    if(userIdFrom!=userIdTo)
    {      
    for(Userdata ud:userlist)
        {
            int temp=ud.getUserId().intValue();
            System.out.println("hello yash"+temp);
            if(temp==userIdFrom)
            {
                 flag_useridFrom=true;
            }
            else
                if(temp==userIdTo)
            {
                flag_useridTo=true;
            }
                if(flag_useridFrom==true && flag_useridTo==true)
            {
                    create(tb);
                    return 1;
            }
        }
    }
    
    return 0;
*/
   create(tb);
   return 1;
}
    else
    {
        return 0;
    }
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
    
}
