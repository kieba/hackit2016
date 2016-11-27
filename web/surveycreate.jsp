<%--
  Created by IntelliJ IDEA.
  User: kieba
  Date: 26.11.2016
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@page import="sun.reflect.ReflectionFactory.GetReflectionFactoryAction"%>
<%@ page import="standard.AccountLogic" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    AccountLogic logic = new AccountLogic(Integer.parseInt(request.getParameter("account_id")));
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
            <li><a href="surveylist.jsp?account_id=<%=logic.getUser().getId()%>">SurveyList</a></li>
            <li><a href="surveycreate.jsp?account_id=<%=logic.getUser().getId()%>">NewRequest</a></li>
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
  <form name="newForm" action="NewSurvey" method="post">
  	<div class="form-group">
  		<label for="title">Titel:</label><input type="text" name="title" value="" class="form-control"/>
  	</div>
  	<div class="form-group">
  		<label for="description">Beschreibung:</label><textarea name="description" rows="3" cols="10" class="form-control"></textarea>
  	</div>
  	<div class="form-group">
  		<label for="validUntil">Gültig bis:</label><input type="date" name="validUntil" class="form-control"/></br>
  	</div>
  	<div class="form-group">
  		<label for="question1">Frage 1:</label><input type="text" name="question1" value="" class="form-control"/>
  	</div>
  	<div class="form-group">
  		<label for="countOptions1">Anzahl Optionen:</label><input type="number" id="countOptions1" name="countOptions1" value="6" onChange="showOptions(1)" class="form-control"></br>
  	</div>
  	<div id="optionContainer1">&nbsp;</div>
  	<div id="questionContainer">&nbsp;</div>
      <input type="hidden" name="quantityQuestions" id="quantityQuestions" value="1">
  	<input type="button" value="Weitere Frage hinzufügen" onClick="addQuestion()" class="btn btn-primary"/>
  	<input type="submit" value="Absenden" class="btn btn-primary"/>
      <%=logic.printHiddenField()%>
  </form>
  <!-------------------------CONTENT LOAD END------------------------->
	  <footer class="footerup">
	  	<p>2016 Citizen , HACKATHON ACCENTURE </p>
	  </footer>
  </div>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
   <script type="text/javascript">
   		var questions = 1;
    	function showOptions(questionNo){
			var optionCount = document.getElementById('countOptions' + questionNo).value;
			var i, pos;
			var optionContent = '';
			for(i=0;i<optionCount;i++) {
				pos = i+1;
				optionContent += '<span>Option: ' + pos + '</span><input name="option_' + questionNo + '_' + pos + '" type="text" class="form-control"/></p>';
				}
			document.getElementById('optionContainer'+questionNo).innerHTML = optionContent;
        }

        function addQuestion(){
            	questions++;
            	document.getElementById("quantityQuestions").value=questions;

            	var questionString = document.getElementById('questionContainer').innerHTML;
            	questionString += '<div class="questionbox"><label for="question' + questions + '">Frage ' + questions + ':</label><input type="text" name="question' + questions + '" value="" class="form-control"/><label for="countOptions' + questions + '">Anzahl Optionen:</label><input class="form-control" type="number" id="countOptions' + questions + '" name="countOptions' + questions + '" value="6" onChange="showOptions(' + questions + ')"></br><div id="optionContainer' + questions + '">&nbsp;</div></div>';
            	document.getElementById('questionContainer').innerHTML = questionString;
            	showOptions(questions);
            }

    	 showOptions(1)
    </script>
  </body>
</html>
