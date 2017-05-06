/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import SessionBeans.TransactionTableFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.scene.control.Alert;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author code_eagle
 */
public class Transaction extends HttpServlet {

        @EJB
        TransactionTableFacadeLocal obj;     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Transaction</title>");            
            out.println("</head>");
            out.println("<body>");
            if(request.getParameter("accountId") == null)
            {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Account Number Absent');");
                out.println("</script>");
            }
            else
            {
            Integer id=Integer.parseInt(request.getParameter("accountId"));
            //Integer id=Integer.parseInt(request.getParameter("userId"));
            Double amt=Double.parseDouble(request.getParameter("amount"));
            int currentuserId=Integer.parseInt((String)request.getSession().getAttribute("userId"));
            System.out.println("my current user id "+currentuserId+"  "+id+"  "+amt);
            int result=obj.transact(currentuserId,id,amt);
            out.println("<h1>Servlet Transaction at " + result + "</h1>");
            out.println("</body>");
            out.println("</html>");
            }
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
