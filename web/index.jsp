<%--
  Created by IntelliJ IDEA.
  User: kieba
  Date: 26.11.2016
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title><%="UmfrageTitel"%></title>
  </head>
  <body>
  	<form method="post" name="opinion" action="opinion.jsp">
  		<label for="name">Teilnehmer:</label><input type="text" name="citizen" value=""/><br/>
  		<p>Sollte das städtische Hallenbad Ihrer Meinung nach renoviert werden?</p>
  		<div style="float:left;width:150px;"><p style="1en;">Auf keinen Fall</p><input type="radio" name="question_1" value="1"><p>1</p></div>
  		<div style="float:left;width:150px;"><p style="1en;">&nbsp;</p><input type="radio" name="question_1" value="2"><p>2</p></div>
  		<div style="float:left;width:150px;"><p style="1en;">Eher nein</p><input type="radio" name="question_1" value="3"><p>3</p></div>
  		<div style="float:left;width:150px;"><p style="1en;">Eher ja</p><input type="radio" name="question_1" value="4"><p>4</p></div>
  		<div style="float:left;width:150px;"><p style="1en;">&nbsp;</p><input type="radio" name="question_1" value="5"><p>5</p></div>
  		<div style="float:left;width:150px;"><p style="1en;">Auf jeden Fall</p><input type="radio" name="question_1" value="6"><p>6</p></div>
  		
  		<div style="clear:both;"><input type="submit" value="Absenden"/></div>
  	</form>
  </body>
</html>
