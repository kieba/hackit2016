import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PollPart;
import model.PollPartAnswer;
import model.User;

/**
 * Servlet implementation class Opinion
 */
@WebServlet("/Opinion")
public class Opinion extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Opinion() {
    	
        String test = "";
        test = test;
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
		User citizen = new User(request.getParameter("citizen"));
		//PollPart pollPart = (PollPart) request.getParameter("poll_part");
		//Object answer = request.getParameter("question_1");
		//PollPartAnswer answer = new PollPartAnswer(po); 
		doGet(request, response);
	}

}
