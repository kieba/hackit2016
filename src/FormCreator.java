

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Poll;

/**
 * Servlet implementation class FormCreator
 */
public class FormCreator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormCreator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Poll poll = SimpleStorage.getINSTANCE().getPollById(-1);
		PrintWriter out = response.getWriter();
		 out.println("<!DOCTYPE html>");
         out.println("<html><head>");
         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
         out.println("<title>" + poll.getTitle() + "</title></head>");
         out.println("<body>");
         out.println("<p>" + poll.getTitle() + "</p>");
         out.println("<p>" + poll.getDescription() + "</p>");
         out.println("</p>");  
         out.println("<form name=\"opinion\" action=\"${pageContext.request.contextPath}/Opinion\" method=\"post\">");
         out.println("<label for=\"name\">Teilnehmer:</label><input type=\"text\" name=\"citizen\" value=\"\"/><br/>");
         out.println("<div style=\"clear:both;\"><input type=\"submit\" value=\"Absenden\"/></div>");
         out.println("</form>");
         out.println("</body>");
         out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
