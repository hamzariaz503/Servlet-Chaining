import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import java.util.*;
import javax.servlet.http.*;


public class DeleteBooks extends HttpServlet{
 
  public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
      

    HttpSession Sess= request.getSession();
   String user= Sess.getAttribute("name").toString();
     

      PrintWriter out = response.getWriter();
     
     String id = request.getParameter("bid");
     
     out.println("<Head>");
     out.println("<title> BOOKS </title>");
     out.println("<body>");

    try{

    Class.forName("com.mysql.jdbc.Driver");

    String url = "jdbc:mysql://127.0.0.1/books";

    Connection con=DriverManager.getConnection(url, "root", "root");

    Statement st=con.createStatement();

     
 //out.println("<h6>"+userName+"</h6>");
     
// out.println("<h6>"+password+"</h6>");


    String query = "delete from bookrecords where bookid ='"+id+"'";


      int rs= st.executeUpdate(query);
  
   
     if(rs==1)
     {
     
      out.println("<h3>"+ " Congratulations  for "+user+"<br><br><br></h3>");
       out.println("<h3>Book has been removed</h3>");

      }
    else
        {

  out.println("<h3>"+ " Disappointment for "+user+"<br><br></h3>");
       out.println("<h3>No record removed</h3>");
     }
}
catch(Exception e){

      out.println(e);
    }
   
     out.println("</body>");
     out.println("</Head>");
     out.close();
  }
}
