/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import EntityBeans.TransactionTable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author code_eagle
 */
@Local
public interface TransactionTableFacadeLocal {

    void create(TransactionTable transactionTable);

    void edit(TransactionTable transactionTable);

    void remove(TransactionTable transactionTable);

    TransactionTable find(Object id);

    List<TransactionTable> findAll();

    List<TransactionTable> findRange(int[] range);

    int count();
    
    public int transact(int userIdFrom, int userIdTo, double amt);
    public ArrayList<ArrayList<String>> trasactionHistory(int account_id);
    public int getTotalentries();
}
