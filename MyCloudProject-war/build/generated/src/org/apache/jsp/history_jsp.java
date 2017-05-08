package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import SessionBeans.TransactionTableFacadeLocal;
import javax.ejb.EJB;

public final class history_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


     @EJB
    TransactionTableFacadeLocal obj;
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<title>\r\n");
      out.write("\t\tTransaction history\r\n");
      out.write("\t</title>\r\n");
      out.write("\r\n");
      out.write("\t<meta charset=\"utf-8\">\r\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n");
      out.write("  <link href=\"https://fonts.googleapis.com/css?family=Montserrat\" rel=\"stylesheet\">\r\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js\"></script>\r\n");
      out.write("  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\r\n");
      out.write(" ");
      out.write("\r\n");
      out.write("  <style type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("  p {font-size: 16px;}\r\n");
      out.write("\r\n");
      out.write("  .margin {margin-bottom: 45px;}\r\n");
      out.write("  \t\r\n");
      out.write("  \t.bg-1 { \r\n");
      out.write("      background-color: #1abc9c; /* Green */\r\n");
      out.write("      color: #ffffff;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("   .bg-2 { \r\n");
      out.write("      background-color: #474e5d; /* Dark Blue */\r\n");
      out.write("      color: #ffffff;\r\n");
      out.write("      padding-bottom: 30px;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  .bg-3 { \r\n");
      out.write("      background-color: #ffffff; /* Dark Blue */\r\n");
      out.write("      color: #000000;\r\n");
      out.write("      margin: 10px;\r\n");
      out.write("  }\r\n");
      out.write("  .bg-4 { \r\n");
      out.write("\r\n");
      out.write("      background-color: #2f2f2f; /* Black Gray */\r\n");
      out.write("      color: #fff;\r\n");
      out.write("  }\r\n");
      out.write("  </style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div class=\"container-fluid bg-1 text-center\">\r\n");
      out.write("  \r\n");
      out.write("  <img src=\"user1.png\" class=\"img-responsive img-circle margin\" style=\"display:inline\" alt=\"Bird\" width=\"320\" height=\"300\">\r\n");
      out.write("  <h3>USER NAME</h3>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"container-fluid bg-2 text-center\">\r\n");
      out.write("  <h3 class=\"margin\" id=\"about\">Transaction History</h3>\r\n");
      out.write("  <p>Note: Please contact the bank if you see any discrepancies.</p>\r\n");
      out.write(" <a href=\"###########################LINK FOR CONTACT PAGE###############\" class=\"btn btn-default btn-lg\">\r\n");
      out.write("    <span class=\"glyphicon glyphicon-search\"></span> CONTACT</a>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- FOR HEADING -->\r\n");
      out.write("<div class=\"container-fluid bg-4 text-center\">\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"row\">\r\n");
      out.write("\t\t<div class=\"col-md-3\" > FROM</div>\r\n");
      out.write("\t\t<div class=\"col-md-3\" > TO</div>\r\n");
      out.write("\t\t<div class=\"col-md-3\" > AMOUNT</div>\r\n");
      out.write("\t\t<div class=\"col-md-3\" > DATE</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- HERE YOU'LL APPLY FOR LOOP WITH THE DETAILS FILLED IN-->\r\n");
int id=Integer.parseInt((String)request.getSession().getAttribute("userId"));
            ArrayList<ArrayList<String>> arlist=new ArrayList<ArrayList<String>>(obj.trasactionHistory(id));
            for(ArrayList temp:arlist)
            {
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"container-fluid bg-3 text-center\">\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"row\">\r\n");
      out.write("\t\t<div class=\"col-md-3\" > ");
      out.print( temp.get(0));
      out.write("</div>\r\n");
      out.write("                <div class=\"col-md-3\" > ");
      out.print( temp.get(1));
      out.write("</div>\r\n");
      out.write("\t\t<div class=\"col-md-3\" > ");
      out.print( temp.get(2));
      out.write("</div>\r\n");
      out.write("\t\t<!--<div class=\"col-md-3\" > /5/2017</div>-->\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!-- END OF LOOP-->\r\n");
      out.write("\r\n");
      out.write("<div class=\"container-fluid bg-4 text-center\">    \r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
