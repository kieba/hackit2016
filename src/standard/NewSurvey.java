package standard;

import model.Politician;
import model.Poll;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Servlet implementation class NewOpinion
 */
public class NewSurvey extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewSurvey() {
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
		IStorage storage = SimpleStorage.getINSTANCE();

		Politician politician = (Politician) storage.getUser(2);
		
		long validUntil = 0l;
		String validUntilString = request.getParameter("validUntil");
		try {
			if(validUntilString != null) {
				Date test = SimpleDateFormat.getDateInstance().parse(validUntilString);
				validUntil = test.getTime();
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		storage.savePoll(new Poll(politician, request.getParameter("title"), validUntil, request.getParameter("description")));
		doGet(request, response);
	}

}
