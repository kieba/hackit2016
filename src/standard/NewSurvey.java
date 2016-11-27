package standard;

import model.Politician;
import model.Poll;
import model.PollPart;
import model.PollPartOption;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

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
		if(validUntilString == null || "".equals(validUntilString))
			return;
		
		try {
			if(validUntilString != null) {
				Date test = SimpleDateFormat.getDateInstance().parse(validUntilString, "S");
				validUntil = test.getTime();
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String titleString = request.getParameter("title");
		String descriptionString = request.getParameter("description");
		if(titleString == null || "".equals(titleString) || descriptionString == null || "".equals(descriptionString))
			return;
		
		Poll poll = new Poll(politician, titleString, validUntil, descriptionString);
		String quantityQuestionsString = request.getParameter("quantityQuestions");
		if(quantityQuestionsString == null || "".equals(quantityQuestionsString)) {
			return;
		}
		int quantityQuestions = Integer.valueOf(quantityQuestionsString);
		int position;
		for(int i = 0;i < quantityQuestions;i++){
			position = i+1;
			LinkedList<PollPartOption> options = new LinkedList<>();
			String countOptionsString = request.getParameter("countOptions"+position);
			if(countOptionsString == null || "".equals(countOptionsString))
				return;
			int countOptions = Integer.valueOf(countOptionsString);
			int optionPos = 0;
			for(int j = 0; j < countOptions; j++) {
				optionPos = j+1;
				options.add(new PollPartOption(optionPos, request.getParameter("option_" + position + "_" + optionPos), String.valueOf(optionPos)));
			}
			poll.addPollPart(new PollPart(options, position, request.getParameter("question"+position)));
		}
		storage.savePoll(poll);
		
		doGet(request, response);
	}

}
