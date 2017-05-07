/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import SessionBeans.AccountsFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author code_eagle
 */
public class createAccount extends HttpServlet {
        
    @EJB
    AccountsFacadeLocal obj;
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int userId=Integer.parseInt((String)request.getSession().getAttribute("userId"));
        String accountType=(String)request.getParameter("account_type");
        Double amount;
        System.out.println("check "+request.getParameter("initial_amount"));
        if(request.getParameter("initial_amount") == null )
            amount=0.0;
        else
            amount=Double.parseDouble(request.getParameter("initial_amount"));
        
        System.out.println("yash"+ (String)request.getParameter("account_pin"));
        int pin=Integer.parseInt((String)request.getParameter("account_pin"));
        int result=obj.createNewAccount(userId, accountType, amount, pin);
        if(result==1)
            System.out.println("Success creation");
        else
            System.out.println("failure creation");
        
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
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
