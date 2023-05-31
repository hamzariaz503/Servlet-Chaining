import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class Login extends HttpServlet {
  
  //Process the HTTP Get request
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
  String userName=request.getParameter("uname");


  HttpSession Sess= request.getSession();
    Sess.setAttribute("name",userName);
     
	response.setContentType("text/html");
    
	// get PrintWriter object
	PrintWriter out = response.getWriter();

  
    String password=request.getParameter("psw");
    String UsType=request.getParameter("type");

    int UserType=Integer.parseInt(UsType);


    out.println("<html>");
    out.println("<head><title>Response</title></head>");
    out.println("<body bgcolor=\"#ffffff\">");

  out.println("<h3>"+UserType+"</h3>");
    try{

    Class.forName("com.mysql.jdbc.Driver");

    String url = "jdbc:mysql://127.0.0.1/books";

    Connection con=DriverManager.getConnection(url, "root", "root");

    Statement st=con.createStatement();

     
 //out.println("<h6>"+userName+"</h6>");
     
// out.println("<h6>"+password+"</h6>");


     String query="Select * from credentials";
   
     ResultSet rs = st.executeQuery( query );
  
     boolean c=true;
   
     while(rs.next()){


    	    String Username = rs.getString("username");


            String Password = rs.getString("password");

        


// out.println("<h6>" +" TablePassword: "+Password+"</h6>");


                    
           if((userName.equals(Username))&& (password.equals(Password))&&(UserType==1))
         { 
            c=false;
       
           response.sendRedirect("http://localhost:8080/ServletChainingwithSession/Admin.html");
           return;

           }

          else if(userName.equals(Username)&& password.equals(Password)&&UserType==0 )
           {  
              c=false;
   
  
           response.sendRedirect("http://localhost:8080/ServletChainingwithSession/TypicalUser.html");
             return;
           }

	  }
   
  if(c){
     
    	 out.println("<h1>Invalid Login credentials</h1>");
}

     out.println("</body></html>");

           st.close();
           con.close();

    }catch(Exception e){

      out.println(e);
    }

  }

}
