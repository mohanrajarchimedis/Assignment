/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mohan
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/fetch")
public class fetch extends HttpServlet{
	
	
	
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException{
	   request.getRequestDispatcher("WEB-INF/Views/fetch.jsp").forward(request,response);
	}
	
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException{
                        PrintWriter out = response.getWriter();
			
                        String filter = request.getParameter("filter");
			// JDBC driver name and database URL
		      final String DB_URL="jdbc:mysql://localhost:3306/archi?autoReconnect=true&useSSL=false";
		      
		      //  Database credentials
		      final String USER = "root";
		      final String PASS = "root";

		      try {
		         // Register JDBC driver
		         Class.forName("com.mysql.cj.jdbc.Driver");

		         // Open a connection
		         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

		         // Execute SQL query
		         Statement stmt = conn.createStatement();
		         String sql;
		         sql = "select * from medicine where nameOfMedicine like '%"+filter+"%'";

		         ResultSet rs = stmt.executeQuery(sql);
		        
		         out.println("<html>");
	        	 out.println("<head>");
	        	 out.println("<title>Fetch Data Result</title>");
	        	 out.println("</head>");
	        	 out.println("<body>");
	        	 out.println("<table border=1 width=100% height=100%>");  
	             out.println("<tr><th>Name of Medicine</th><th>Manufactured from</th><th>Expiry Date</th><th>Price</th><tr>");
		         // Extract data from result set
		         while(rs.next()){
		         String nameofmedicine = rs.getString("nameOfMedicine");  
	                 String manufacturefrom = rs.getString("manufactureFrom");   
	                 String expireddate = rs.getString("expiredDate");
	                 String price = rs.getString("price");
	                
	                 out.println("<tr><td>" + nameofmedicine + "</td><td>" + manufacturefrom + "</td><td>"+ 
	                		  expireddate + "</td><td>"+price + "</td></tr>");   
	             }  
	             out.println("</table>");  
	             out.println("</body></html>");  
			         

		         // Clean-up environment
		         rs.close();
		         stmt.close();
		         conn.close();
		      } catch(SQLException se) {
		         //Handle errors for JDBC
		         se.printStackTrace();
		      } catch(Exception e) {
		         //Handle errors for Class.forName
		         e.printStackTrace();
		      }
		     
	}
	
}