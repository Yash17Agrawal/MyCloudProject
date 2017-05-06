/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import EntityBeans.Userdata;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author code_eagle
 */
@Local
public interface UserdataFacadeLocal {

    void create(Userdata userdata);

    void edit(Userdata userdata);

    void remove(Userdata userdata);

    Userdata find(Object id);

   List<Userdata> findAll();

    List<Userdata> findRange(int[] range);

    int count();
   public int login(String username, String password);
  public int signup(String username,String password,String verification_type,Integer verification_number,String security_question,String security_answer);

          public String getVerificationType(String id);
            public int getVerificationNumber(String id);
            public String getname(String id);
public ArrayList<Userdata> getAllusers();
}
