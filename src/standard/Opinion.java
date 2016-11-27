package standard;

import exception.AlreadyVotedException;
import exception.InvalidRequestException;
import model.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;

/**
 * Servlet implementation class standard.Opinion
 */
public class Opinion extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */

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

		User user = storage.getUser(Integer.parseInt(request.getParameter("citizen")));
		Citizen citizen;
		if(user instanceof Citizen){
			citizen = (Citizen)user;
		}else{
			throw new InvalidRequestException("No user given.");
		}

		try {
			storage.doVote(new PollAnswer(storage.getPollById(Integer.parseInt(request.getParameter("poll_id"))),citizen));
		} catch (AlreadyVotedException e) {
			return;
		}

		Poll currentPoll = storage.getPollById(Integer.parseInt(request.getParameter("poll_id")));
		Iterator<PollPart> iterator = currentPoll.getPollParts();

		while (iterator.hasNext()){
			PollPart part = iterator.next();
			part.addVote(Integer.parseInt(request.getParameter("pollPart_id" + part.getPartNo())));
		}

		storage.savePoll(currentPoll);
		doGet(request, response);
	}

}
