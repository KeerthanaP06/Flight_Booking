package Login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class NextPage
 */
@WebServlet("/NextPage")
public class NextPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NextPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginDao l = new LoginDao();
	    String Name = request.getParameter("Name");
	    String phone = request.getParameter("phone");
	    String city_from = request.getParameter("city_from");
	    String destination = request.getParameter("destination");
	    String num_seats = request.getParameter("num_seats");
	    User u = new User(Name, phone, city_from, destination, num_seats);
	    try {
	        if (l.insertDetails(u)) {
	            response.sendRedirect("Success.jsp");
	        } else {
	            response.sendRedirect("Booking.jsp");
	        }
	    } catch (SQLException e) {
	        // Log the exception for debugging
	        e.printStackTrace();
	        // You can also log the exception to a log file
	        // logger.error("An error occurred", e);
	        response.sendRedirect("Error.jsp"); // Redirect to an error page
	    }

	}
}


