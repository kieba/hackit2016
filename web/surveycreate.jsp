<%--
  Created by IntelliJ IDEA.
  User: kieba
  Date: 26.11.2016
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@page import="sun.reflect.ReflectionFactory.GetReflectionFactoryAction"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
	              <input type="text" placeholder="Firstname" class="form-control">
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
  <form name="newForm" action="standard.NewSurvey" method="post">
  	<label for="title">Titel:</label><input type="text" name="title" value=""/>
  	<label for="description">Beschreibung:</label><textarea name="description" rows="3" cols="10"></textarea>
  	<label for="validUntil">Gültig bis:</label><input type="date" name="validUntil"/></br>
  	<label for="question1">Frage 1:</label><input type="text" name="question1" value=""/>
  	<label for="countOptions1">Anzahl Optionen:</label><input type="number" id="countOptions1" name="countOptions1" value="6" onChange="showOptions(1)"></br>
  	<div id="optionContainer1">&nbsp;</div>
  	<div id="questionContainer">&nbsp;</div>
  	<input type="button" value="Weitere Frage hinzufügen" onClick="addQuestion()"/>
  	<input type="submit" value="Absenden"/>
  </form>
  <!-------------------------CONTENT LOAD END------------------------->
	  <footer>
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
				optionContent += '<span>' + pos + '</span><input name="option' + pos + 'text" type="text"/></p>';
				}
			document.getElementById('optionContainer'+questionNo).innerHTML = optionContent;
        }

        function addQuestion(){
            	questions++;
            	
            	var questionString = document.getElementById('questionContainer').innerHTML;
            	questionString += '<label for="question' + questions + '">Frage ' + questions + ':</label><input type="text" name="question' + questions + '" value=""/><label for="countOptions' + questions + '">Anzahl Optionen:</label><input type="number" id="countOptions' + questions + '" name="countOptions' + questions + '" value="6" onChange="showOptions(' + questions + ')"></br><div id="optionContainer' + questions + '">&nbsp;</div>';
            	document.getElementById('questionContainer').innerHTML = questionString;
            	showOptions(questions);
            }

    	 showOptions(1)
    </script>
  </body>
</html>
