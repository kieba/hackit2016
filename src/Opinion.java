import exception.InvalidRequestException;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Opinion
 */
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
		User citizen = SimpleStorage.getINSTANCE().getUser(request.getParameter("citizen"));
		if(citizen == null){
			throw new InvalidRequestException("No user given.");
		}


		//PollPart pollPart = (PollPart) request.getParameter("poll_part");
		//Object answer = request.getParameter("question_1");
		//PollPartAnswer answer = new PollPartAnswer(po);
		doGet(request, response);
	}

}
