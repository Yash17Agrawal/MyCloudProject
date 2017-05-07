/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import EntityBeans.LoanTable;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author code_eagle
 */
@Stateless
public class LoanTableFacade extends AbstractFacade<LoanTable> implements LoanTableFacadeLocal {

    @PersistenceContext(unitName = "MyCloudProject-ejbPU")
    private EntityManager em;

    @EJB
    TransactionTableFacadeLocal transactionObj;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LoanTableFacade() {
        super(LoanTable.class);
    }
    public int takeLoan(int userId,Double amount,Double time,Double rate)
    {
        //-1 is denoting Bank itself for loan purposes
        LoanTable obj=new LoanTable();
        transactionObj.transact(-1, userId, amount);
        obj.setTransactionId(transactionObj.getTotalentries());
        obj.setAccountId(userId);
        obj.setDuration(time);
        obj.setPrincipal(amount);
        obj.setRate(rate);
        create(obj);
        return 1;
    }
}
