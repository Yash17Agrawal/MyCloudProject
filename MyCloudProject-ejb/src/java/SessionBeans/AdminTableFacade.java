/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import EntityBeans.AdminTable;
import EntityBeans.Userdata;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author code_eagle
 */
@Stateless
public class AdminTableFacade extends AbstractFacade<AdminTable> implements AdminTableFacadeLocal {

    @PersistenceContext(unitName = "MyCloudProject-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdminTableFacade() {
        super(AdminTable.class);
    }
    public int login(String userId,String password)
    {
        Boolean flag=false;
        ArrayList<AdminTable> userlist=new ArrayList(findAll());
        for(AdminTable ud:userlist)
        {
            Integer userid=Integer.parseInt(userId);
            if(ud.getAdminId().equals(userid) && ud.getAdminPassword().equals(password))
            {
                 flag=true;
                 break;
            }
        }
        if(flag)
        {
            return 1;
        }
        return 0;
    }
}
