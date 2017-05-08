/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import EntityBeans.AdminTable;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author code_eagle
 */
@Local
public interface AdminTableFacadeLocal {

    void create(AdminTable adminTable);

    void edit(AdminTable adminTable);

    void remove(AdminTable adminTable);

    AdminTable find(Object id);

    List<AdminTable> findAll();

    List<AdminTable> findRange(int[] range);

    int count();
    public int login(String userid,String password);
    
}
