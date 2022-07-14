package p_03;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Servlet implementation class loginServelet
 */
public class loginServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//out.print usage need below implementations
		PrintWriter out =response.getWriter();
		response.setContentType("text/html");
		
		//gets the values from input tags from the login page boxes
		String useremail = request.getParameter("email");
		String password = request.getParameter("pass");
		
		//noolean type variable for checking return type 
		boolean isTrue;
		// below expression save the return type tre or false in the isTrue variable 
		isTrue = CustomerDbUtill.validate(useremail, password);
		//if true then below segments ge exeuted
		if (isTrue == true) {
			List<Customer> cusDetails = CustomerDbUtill.getCustomer(useremail);
			request.setAttribute("cusDetails", cusDetails);

			//redirect to index.html if credenials are correct
			RequestDispatcher dis = request.getRequestDispatcher("index.html");
			dis.forward(request, response);
		}
		else {
			//scipt for show incoret credentials
			out.println("<script type='text/javascript'>");
			out.println("alert('Your credwentials are  incorrect');");
			out.println("location='login.jsp'");
			out.println("</script>");
		}
	}

}
