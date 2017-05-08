/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import EntityBeans.Accounts;
import java.util.ArrayList;
import java.util.HashMap;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author code_eagle
 */
@Stateless
public class AccountsFacade extends AbstractFacade<Accounts> implements AccountsFacadeLocal {

    @PersistenceContext(unitName = "MyCloudProject-ejbPU")
    private EntityManager em;

    @EJB
    TransactionTableFacadeLocal obj;
    
    @PersistenceUnit(unitName = "MyCloudProject-ejbPU")
    EntityManagerFactory emf;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccountsFacade() {
        super(Accounts.class);
    }
    
    public int createNewAccount(int userId,String accountType,Double initialAmount,int pin)
    {
        Accounts ac=new Accounts();
        ac.setUserId(userId);
        ac.setAmount(initialAmount);
        //ac.setLoan(null);
        ac.setPin(pin);
        ac.setAccountType(accountType);
        create(ac);
        
    
            int c=obj.transact(-1, userId, initialAmount);
            if(c!=1)
                return 0;
        
        return 1;
    }
     public Integer getAccountnumber(int userid)
        {
            ArrayList<Accounts> obj=new ArrayList<>(findAll());
            for(Accounts temp:obj)
            {
                if(userid == temp.getUserId())
                {
                    return temp.getAccountId();
                }
            }
            return null;
        }
     public HashMap<Integer, ArrayList> getAccountDetails(int userid)
     {
         ArrayList<ArrayList<String>> final_list = new ArrayList();
         ArrayList<Accounts> obj = new ArrayList<>(findAll());
         HashMap<Integer, ArrayList> hmap = new HashMap();
         for (Accounts temp: obj)
         {
             if (temp.getUserId() == userid)
             {
                 ArrayList<String> temp_account = new ArrayList();
                 String acc_id = temp.getAccountId().toString();
                 String acc_amount = temp.getAmount().toString();
                 String acc_type = temp.getAccountType();
                 
                 temp_account.add(acc_id);
                 temp_account.add(acc_type);
                 temp_account.add(acc_amount);
                 
                 final_list.add(temp_account);
                 temp_account.clear();
             }
         }
         hmap.put(userid, final_list);
         return hmap;
     }
     
      public Double getAmount(int id)
      {
         // ArrayList<Accounts> arlist=(ArrayList < Accounts>)emf.createEntityManager().createNamedQuery("Accounts.findByAccountId").setParameter("account_id", id).getResultList();
          
          //return arlist.get(0).getAmount();
          Accounts ab=find(id);
          return ab.getAmount();
      }
      public int set_Amount(int id,int factor,double change,int loan_id)
      {
          //Add amount
          if(factor==1)
          {
              Accounts ac=find(id);
              double tempAmount=ac.getAmount();
              ac.setAmount(tempAmount + change );
              if(loan_id >0)
                  ac.setLoanId(loan_id);
          }
          else
              // Subtract
              if(factor==0)
              {
                   Accounts ac=find(id);
                   double tempAmount=ac.getAmount();
                   ac.setAmount(tempAmount - change );
                   
              }
        return 1;  
      }
}
