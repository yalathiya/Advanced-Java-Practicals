import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

/**
 * @author Yash
 */
public class Unit3Practical5Servlet extends HttpServlet {

   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String enrollmentNumber = request.getParameter(101);

      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con =  DriverManager.getConnection(jdbc:mysql://localhost:3306/advancejavapractical","root","Yash@2233);
         PreparedStatement ps = con.prepareStatement("select * from marksheet where enrollment_number=?");

         ps.setString(1,enrollmentNumber);
         ResultSet rs = ps.executeQuery();

         if(rs.next()){
            out.println("<html><body>");
            out.println("<h2>Mark Sheet of "+rs.getString("name")+"</h2>");
            out.println("<table border='1'>");
            out.println("<tr><td>Subject1 Marks:</td><td>"+rs.getInt("MATHS")+"</td></tr>");
            out.println("<tr><td>Subject2 Marks:</td><td>"+rs.getInt("PHYSICS")+"</td></tr>");
            out.println("<tr><td>Subject3 Marks:</td><td>"+rs.getInt("SCIENCE")+"</td></tr>");
            out.println("<tr><td>Total Marks:</td><td>"+rs.getInt("total_marks")+"</td></tr>");
            out.println("</table>");
            out.println("</body></html>");
         }else{
            out.println("<html><body>");
            out.println("<h2>No Record Found for Enrollment Number "+enrollmentNumber+"</h2>");
            out.println("</body></html>");
         }
     
      } catch (Exception e) {
         out.println("<html><body>");
         out.println("<h2>Error Occurred:"+e+"</h2>");
         out.println("</body></html>");
      }
   }
}
