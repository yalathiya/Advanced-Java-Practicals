import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 * @author Yash
 */
public class Unit3Practical2Servlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);

        // Get the current visit count from the session
        Integer count = (Integer)session.getAttribute("count");
        if (count == null) {
            count = new Integer(1);
        } else {
            count = new Integer(count.intValue() + 1);
        }

        // Store the updated count back in the session
        session.setAttribute("count", count);

        // Set the response content type
        response.setContentType("text/html");

        // Write the response
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Visit Counter Servlet</title></head>");
        out.println("<body><h2>Total Visits: " + count + "</h2></body></html>");
    }
}
