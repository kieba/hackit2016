<%--
  Created by IntelliJ IDEA.
  User: kieba
  Date: 26.11.2016
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@page import="model.Poll"%>
<%@ page import="model.PollPart" %>
<%@ page import="model.PollPartOption" %>
<%@ page import="standard.SimpleStorage" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="standard.AccountLogic" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    AccountLogic logic = new AccountLogic(Integer.parseInt(request.getParameter("account_id")));
%>
<%!


    private String printPart(PollPart part){
    	StringBuilder builder = new StringBuilder();

	   builder.append("<table class=\"table\">");
	   builder.append("<tr colspan=\"" + part.getOptions().size() + "\"><td>" + part.getQuestion() + "</td></tr>");
	   builder.append("<tr>");

    	for(PollPartOption option : part.getOptions()){
    		builder.append(printOption(option));
    	}

    	builder.append("</tr>");
    	builder.append("</table>");
    	return builder.toString();
    }

    private String printOption(PollPartOption option){
    	return "<td>" + option.getDescription() + ":" + option.getVotes() + "</td>";
    }
%>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><%="Citizen Opinion"%></title>
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
            <a class="navbar-brand logopadder" href="index.jsp">
                <img alt="logo" src="img/logo2.png" class="logoresize">
            </a>
        </div>
        <div id="navbar" class="navbar-collapse collapse" >
            <ul class="nav navbar-nav">
                <li><a href="surveylist.jsp?account_id=<%=logic.getUser().getId()%>">Survey List</a></li>
                <li><a href="surveycreate.jsp?account_id=<%=logic.getUser().getId()%>">New Request</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <form class="navbar-form navbar-right">
                    <div class="form-group">
                        <input type="text" placeholder="Firstname" class="form-control" value="<%=logic.getUser().getName()%>">
                    </div>
                </form>

            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
<div class="container">
    <!-------------------------CONTENT LOAD ---------------------------->

    <%


        int id = Integer.parseInt(request.getParameter("id"));
        Poll poll = SimpleStorage.getINSTANCE().getPollById(id);

		out.println("<lable>" + poll.getTitle() + "</label>");
        
        out.print("<table class=\"table\">");
        for (Iterator<PollPart> it = poll.getPollParts(); it.hasNext(); ) {
            PollPart part = it.next();
            out.append("<tr>" + printPart(part) + "</tr>");

        }
        out.print("</table>");
    %>


    <!-------------------------CONTENT LOAD END------------------------->
    <footer class="footerup">
        <p>2016 Citizen , HACKATHON ACCENTURE </p>
    </footer>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
