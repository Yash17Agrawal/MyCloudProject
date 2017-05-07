/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

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
public class UserdataFacade extends AbstractFacade<Userdata> implements UserdataFacadeLocal {

    @PersistenceContext(unitName = "MyCloudProject-ejbPU")
    private EntityManager em;
   
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserdataFacade() {
        super(Userdata.class);
    }
    public int login(String userId, String password)
    {

        Boolean flag=false;
        ArrayList<Userdata> userlist=new ArrayList(findAll());
        for(Userdata ud:userlist)
        {
            Integer userid=Integer.parseInt(userId);
            if(ud.getUserId().equals(userid) && ud.getPassword().equals(password))
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
        public int signup(String username,String password,String verification_type,Integer verification_number,String security_question,String security_answer)
        {
            if(username.isEmpty() || password.isEmpty() || verification_number == null || verification_type.isEmpty() )
            {
                return 0;
            }
            Userdata obj=new Userdata();
            obj.setName(username);
            obj.setPassword(password);
            obj.setSecurityAnswer(security_answer);
            obj.setSecurityQuestion(security_question);
            obj.setVerificationNumber(verification_number);
            obj.setVerificationType(verification_type);
            obj.setStatus("active");
            
            create(obj);
            return 1; 
        }
        
        public String getname(String id)
        {
             ArrayList<Userdata> userlist=new ArrayList(findAll());
            for(Userdata ud:userlist)
        {
            Integer userid=Integer.parseInt(id);
            if(ud.getUserId().equals(userid) )
            {
                 return ud.getName();
            }
        }
            return "Default";
        }
        public int getVerificationNumber(String id)
        {
             ArrayList<Userdata> userlist=new ArrayList(findAll());
               for(Userdata ud:userlist)
        {
            Integer userid=Integer.parseInt(id);
            if(ud.getUserId().equals(userid) )
            {
                 return ud.getVerificationNumber();
            }
        }
            return -1;
        }
        public String getVerificationType(String id)
        {
             ArrayList<Userdata> userlist=new ArrayList(findAll());
               for(Userdata ud:userlist)
        {
            Integer userid=Integer.parseInt(id);
            if(ud.getUserId().equals(userid) )
            {
                 return ud.getVerificationType();
            }
        }
            return "Default";
        }
        
        public ArrayList<Userdata> getAllusers()
        {
            return new ArrayList(findAll());
        }
}
