<%--
  Created by IntelliJ IDEA.
  User: kieba
  Date: 26.11.2016
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@page import="sun.reflect.ReflectionFactory.GetReflectionFactoryAction"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="model.PollPart" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="model.PollPartOption" %>
<%@ page import="model.Poll" %>
<%@ page import="standard.SimpleStorage" %>
<%@ page import="standard.AccountLogic" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    AccountLogic logic = new AccountLogic(Integer.parseInt(request.getParameter("account_id")));
    if(logic == null){
        return;
    }
%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><%="Citizen standard.Opinion"%></title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/custom.css">
</head>
<body>
<nav class="navbar navbar-inverse navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand logopadder" href="?side=startpage">
                <img alt="logo" src="img/logo2.png" class="logoresize">
            </a>
        </div>
        <div id="navbar" class="navbar-collapse collapse" >
            <ul class="nav navbar-nav">
                <li><a href="?side=survey">Survey</a></li>
                <li><a href="?side=request">Request</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <form class="navbar-form navbar-right">
                    <div class="form-group">
                        <input type="text" placeholder="Firstname" class="form-control" value="<%=logic.getUser().getName()%>">
                    </div>
                    <div class="form-group">
                        <input type="password" placeholder="Lastname" class="form-control">
                    </div>
                    <span class="label label-default">Login as:</span>
                    <button type="button" class="btn btn-primary">Citizen</button>
                    <button type="button" class="btn btn-primary">Politician</button>
                </form>

            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
<div class="container">
    <!-------------------------CONTENT LOAD ---------------------------->

    <%

        Poll poll = SimpleStorage.getINSTANCE().getPollById(Integer.parseInt(request.getParameter("id")));

        if(poll != null){
            out.println("<head>");
            out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
            out.println("<title>" + poll.getTitle() + "</title></head>");
            out.println("<body>");
            out.println("<form name=\"" + poll.getId() + "\" action=\"/Opinion\" method=\"post\">");
            out.print(logic.printHiddenField());
            out.println("<div class=\"form-group\">");
            out.println("<label for=\"name\">Participant:</label><br><label>" + logic.getUser().getName()+ "</label><br/>");
            out.println("</div>");
            out.println("<div class=\"form-group survey-gp\">");
            out.println("<label for=\"name\">Title:</label>");
            out.println("<p>" + poll.getTitle() + "</p>");
            out.println("<label for=\"name\">Desciption:</label>");
            out.println("<p>" + poll.getDescription() + "</p>");
            out.println("</div>");
            out.println("<input type=\"hidden\" name=\"poll_id\" value=\"" + poll.getId() + "\">");
            out.println("<div class=\"form-group survey-gp\">");
            Iterator<PollPart> pollPartInterator = poll.getPollParts();
            while(pollPartInterator.hasNext()) {
                PollPart pollParts = pollPartInterator.next();
                out.println("<p>" + pollParts.getQuestion() + "</p>");
                for(int i = 0;i<pollParts.getOptions().size();i++) {

                    PollPartOption option = pollParts.getOptions().get(i);
                    out.println("<div style=\"float:left;width:150px;\"><p style=\"1en;\">" + (option.getDescription() != null && !option.getDescription().equals("") ? option.getDescription() : "&nbsp;") + "</p><input type=\"radio\" name=\"pollPart_id"+ pollParts.getPartNo() + "\" value=\"" + option.getOptionId() + "\"><p>" + option.getValue() + "</p></div>");
                }

            }
            out.println("<div style=\"clear:both;\"><input class=\"btn btn-primary\" type=\"submit\" value=\"Absenden\"/></div>");
            out.println("</div>");
            out.println("</form>");
        }
    %>

    <!-------------------------CONTENT LOAD END------------------------->
    <footer>
        <p>2016 Citizen , HACKATHON ACCENTURE </p>
    </footer>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
