/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import EntityBeans.LoanTable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author code_eagle
 */
@Local
public interface LoanTableFacadeLocal {

    void create(LoanTable loanTable);

    void edit(LoanTable loanTable);

    void remove(LoanTable loanTable);

    LoanTable find(Object id);

    List<LoanTable> findAll();

    List<LoanTable> findRange(int[] range);

    int count();
    public int takeLoan(int userId,Double amount,Double time,Double rate);
    public ArrayList<ArrayList<String>> allEntries(int account_id);
}
