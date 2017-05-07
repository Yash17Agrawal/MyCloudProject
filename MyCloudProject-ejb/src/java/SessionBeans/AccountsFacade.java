/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import EntityBeans.Accounts;
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
        return 1;
    }
}
