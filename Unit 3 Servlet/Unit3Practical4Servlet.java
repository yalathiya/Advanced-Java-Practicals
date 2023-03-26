import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 * @author Yash
 */
public class Unit3Practical4Servlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Get the user's signup information from the request
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");

        // Check if the user already exists
        if (userExists(username)) {
            // If the user already exists, show an error message
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><head><title>Signup Error</title></head>");
            out.println("<body><h2>Signup Error</h2>");
            out.println("<p>The username you entered is already in use. Please choose another username.</p>");
            out.println("</body></html>");
        } else {
            // If the user does not already exist, add the user to the database
            addUser(username, password, name, email, mobile);

            // Set the authenticated user's name in the session
            HttpSession session = request.getSession(true);
            session.setAttribute("user", username);

            // Redirect the user to a welcome page
            response.sendRedirect("welcome.jsp");
        }
    }

    
   private boolean userExists(String username) {
        // This method should be implemented to check if the user already exists
        // For example, you could check a database to see if the username is already in use
        // For simplicity, we'll just hard-code a single user with a username
        return username.equals("myuser");
    }

    private void addUser(String username, String password, String name, String email, String mobile) {
        // This method should be implemented to add the user to the database
        // For example, you could insert the user's information into a database table
        // For simplicity, we'll just print the user's information to the console
        System.out.println("New user added:");
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Mobile: " + mobile);
    }
}
