/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import EntityBeans.Accounts;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
        
       /*if(initialAmount == 0)
        {*/
            int c=obj.transact(userId, userId, initialAmount);
            if(c!=1)
                return 0;
        /*}*/
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
}
