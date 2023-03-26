import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * @author Yash
 */

public class Unit3Practical3Servlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Get the user's name and password from the request
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        // Check if the user is authenticated

        if (isAuthenticated(name, password)) {
            // If the user is authenticated, create a new session
            HttpSession session = request.getSession(true);

            // Set the authenticated user's name in the session
            session.setAttribute("user", name);

            // Redirect the user to a secure page
            response.sendRedirect("secure.jsp");
        } 

        else {
            // If the user is not authenticated, show an error message
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><head><title>Login Error</title></head>");
            out.println("<body><h2>Login Error</h2>");
            out.println("<p>The username or password you entered is incorrect. Please try again.</p>");
            out.println("</body></html>");
        }
    }


    private boolean isAuthenticated(String name, String password) {
        // This method should be implemented to check if the user is authenticated
        // For example, you could check a database to see if the user's name and password are valid
        return name.equals("myuser") && password.equals("mypassword");
    }
}
