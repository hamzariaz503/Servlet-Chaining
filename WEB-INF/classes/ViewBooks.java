import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class ViewBooks extends HttpServlet {
  
  //Process the HTTP Get request
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
	response.setContentType("text/html");
    
 HttpSession Sess= request.getSession();
 String user=Sess.getAttribute("name").toString();
     
	// get PrintWriter object
	PrintWriter out = response.getWriter();

    out.println("<html>");
    out.println("<head><title>Response</title></head>");
    out.println("<body bgcolor=\"#ffffff\">");

    out.println("<h2>"+"Session Object id :"+ user+"<br><br></h2>");

    try{

    Class.forName("com.mysql.jdbc.Driver");

    String url = "jdbc:mysql://127.0.0.1/books";

    Connection con=DriverManager.getConnection(url, "root", "root");

     
 //out.println("<h6>"+userName+"</h6>");
     
// out.println("<h6>"+password+"</h6>");


     String query="SELECT * FROM bookrecords ";
   PreparedStatement pst=con.prepareStatement(query);
   
     ResultSet rs = pst.executeQuery();
  
   
     while(rs.next()){
             int bId = rs.getInt("bookid");
            String bTitle= rs.getString("booktitle");
            String Auth= rs.getString("author");
            String Issn= rs.getString("issn");

  
     out.println("<br><h1>" +" Bookid : "+ bId +"<br><br><h1>");

     out.println("<h6>" +" BookTitle : "+ bTitle +"<br><br><h6>");

     out.println("<h6>" +" BookAuthor : "+ Auth +"<br><br><h6>");

     out.println("<h6>" +" Book ISSN : "+ Issn +"<br><br><h6>");

     out.println("<p>--------------------------------<p>");
    out.println("<p>--------------------------------<p>");

   
      
  }     
  

     out.println("</body></html>");

           pst.close();
           con.close();

    }catch(Exception e)
    
    {

      out.println(e);
    }

  }

}
