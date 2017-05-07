/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;


         

import SessionBeans.AccountsFacadeLocal;
import SessionBeans.UserdataFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author code_eagle
 */
public class LoginSingupNew extends HttpServlet {
            @EJB
            UserdataFacadeLocal obj;
            @EJB 
            AccountsFacadeLocal accobj;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            
          
            String action=request.getParameter("register");
            if(action == null)
            {
                // For Login
            String userId=request.getParameter("userId");
            String password=request.getParameter("password");
            int result=obj.login(userId,password);
            
            if(result==1)
            {
                //Successful Login
                int accountnumber=accobj.getAccountnumber(Integer.parseInt(userId));
                HttpSession session=request.getSession();
                session.setAttribute("userId",userId);
                session.setAttribute("accountNumber",accountnumber);
                // response.sendRedirect("http://localhost:24807/MyCloudProject-war/LoginSignup/AfterLogin.jsp");

               response.sendRedirect("http://localhost:24807/MyCloudProject-war/home.jsp");
            }
            else
            {
                //Bad Login
           response.sendRedirect("http://localhost:24807/MyCloudProject-war/LoginSignup/ErrorLogin.jsp");

            }
            }
            else
            {
                 //For Registration
                String username=request.getParameter("username");
                String password=request.getParameter("password");
                String verification_type=request.getParameter("verification_type");
                Integer verification_number=0;
                if(request.getParameter("verification_number") != null)
                    verification_number=Integer.parseInt(request.getParameter("verification_number"));
                else
                    response.sendRedirect("http://localhost:24807/MyCloudProject-war/LoginSignup/ErrorSignup.jsp");

                String security_question=request.getParameter("security_question");
                String security_answer=request.getParameter("security_answer");
                int result=obj.signup(username, password, verification_type, verification_number, security_question, security_answer);
                if(result==1)
                {
                    /*int userId=obj.login("1", password);
                     HttpSession session=request.getSession();
                session.setAttribute("userId",result);*/
              // response.sendRedirect("http://localhost:24807/MyCloudProject-war/LoginSignup/SuccessSignup.jsp");
                response.sendRedirect("http://localhost:24807/MyCloudProject-war/home.jsp");
                }
               else
                {
                     response.sendRedirect("http://localhost:24807/MyCloudProject-war/LoginSignup/ErrorSignup.jsp");
                }
            }
            //
           
        }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
