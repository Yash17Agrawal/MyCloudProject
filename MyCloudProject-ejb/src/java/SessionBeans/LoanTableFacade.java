/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import EntityBeans.LoanTable;
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
    public ArrayList<ArrayList<String>> allEntries(int account_id)
    {
        ArrayList<LoanTable> loanlist=new ArrayList(findAll());
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<String> temp = new ArrayList();
        for(LoanTable obj:loanlist)
        {
                temp.clear();  
                temp.add(obj.getLoanId().toString());
                temp.add(String.valueOf(obj.getTransactionId()));
                temp.add(String.valueOf(obj.getAccountId()));
                temp.add(String.valueOf(obj.getRate()));
                temp.add(String.valueOf(obj.getPrincipal()));
                temp.add(String.valueOf(obj.getDuration()));
                result.add(new ArrayList<>(temp));   
        }
        System.out.println("final result of loan table " + result); 
        return result;
    }
}
