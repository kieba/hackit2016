

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.StringUtils;
import org.eclipse.jdt.internal.compiler.env.ISourceMethod;

import model.Poll;
import model.PollPart;
import model.PollPartOption;

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
		Poll poll = SimpleStorage.getINSTANCE().getPollById(1);
		PrintWriter out = response.getWriter();
		 out.println("<!DOCTYPE html>");
         out.println("<html><head>");
         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
         out.println("<title>" + poll.getTitle() + "</title></head>");
         out.println("<body>");
         out.println("<form name=\"opinion\" action=\"${pageContext.request.contextPath}/Opinion\" method=\"post\">");
         out.println("<label for=\"name\">Teilnehmer:</label><input type=\"text\" name=\"citizen\" value=\"\"/><br/>");
         out.println("<p>" + poll.getTitle() + "</p>");
         out.println("<p>" + poll.getDescription() + "</p>");
         
         Iterator<PollPart> pollPartInterator = poll.getPollParts();
         while(pollPartInterator.hasNext()) {
        	 PollPart pollParts = (PollPart)pollPartInterator.next(); 
        	 out.println("<p>" + pollParts.getQuestion() + "</p>");
        	 for(int i = 0;i<pollParts.getOptions().size();i++) {
        		 
	    	   PollPartOption option = pollParts.getOptions().get(i);
	    	   out.println("<div style=\"float:left;width:150px;\"><p style=\"1en;\">" + (option.getDescription() != null && !option.getDescription().equals("") ? option.getDescription() : "&nbsp;") + "</p><input type=\"radio\" name=\"question_1\" value=\"" + option.getValue() + "\"><p>" + option.getValue() + "</p></div>");  
        	 }
        	 
         }
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
