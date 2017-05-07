/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import EntityBeans.Accounts;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author code_eagle
 */
@Local
public interface AccountsFacadeLocal {

    void create(Accounts accounts);

    void edit(Accounts accounts);

    void remove(Accounts accounts);

    Accounts find(Object id);

    List<Accounts> findAll();

    List<Accounts> findRange(int[] range);

    int count();
    public int createNewAccount(int userId,String accountType,Double initialAmount,int pin);
    public Integer getAccountnumber(int userid);
}
