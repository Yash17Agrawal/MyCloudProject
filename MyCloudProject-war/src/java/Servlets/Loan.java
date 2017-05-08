/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import SessionBeans.LoanTableFacadeLocal;
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
public class Loan extends HttpServlet {

   @EJB
   LoanTableFacadeLocal obj;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      try (PrintWriter out = response.getWriter()) {
        Double amount=Double.parseDouble(request.getParameter("principalAmount"));
//        System.out.println(request.getParameter("time").substring(0,request.getParameter("time").indexOf(" ")));
        Double time=Double.parseDouble(request.getParameter("time"));
        double rate=Double.parseDouble(request.getParameter("rate"));
        int userId=Integer.parseInt((String)request.getSession().getAttribute("userId"));
        int result=obj.takeLoan(userId,amount,time,rate);
        
        if(result==1)
        {
            System.out.println("Loan Success");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Transaction</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Transaction Success  " + result + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
        }
        else
            System.out.println("Loan Failure");
        
    }
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
