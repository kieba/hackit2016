<%@ page import="model.User" %>
<%@ page import="standard.AccountLogic" %>
<%@ page import="standard.SimpleStorage" %>
<%@ page import="model.Citizen" %>
<%@ page import="exception.AlreadyExistException" %>
<%@ page import="model.Politician" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if(request.getMethod().equals("POST")){
        SimpleStorage storage = SimpleStorage.getINSTANCE();

        String name = request.getParameter("name");
        int postCode = 0;
        if(request.getParameter("postcode")!= null && !request.getParameter("postcode").equals("")){
            postCode = Integer.parseInt(request.getParameter("postcode"));
        }

        boolean isCitizen = request.getParameter("type").equals("citizen");

        User user;

        if(isCitizen){
            try {
                user = storage.createUser(new Citizen(name,postCode));
            } catch (AlreadyExistException e) {
                user = storage.getUser(name);
            }
        }else{
            try {
                Politician politician = new Politician(name);
                politician.addAffiliation(postCode);
                user = storage.createUser(politician);
            } catch (AlreadyExistException e) {
                user = storage.getUser(name);
            }
        }

        response.sendRedirect("/index.jsp?account_id="+user.getId());
        return;
    }


    AccountLogic logic = null;
    if(request.getParameter("account_id")!= null){
        logic = new AccountLogic(Integer.parseInt(request.getParameter("account_id")));
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
  <nav class="navbar navbar-inverse navbar-static-top" style="margin-bottom:0px;">
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
            <%
                if(logic != null){
            %>
          <ul class="nav navbar-nav">
            <li><a href="surveylist.jsp?account_id=<%=logic.getUser().getId()%>">Survey List</a></li>
              <%
                  if(logic.isPolitician()){
              %>
                <li><a href="surveycreate.jsp?account_id=<%=logic.getUser().getId()%>">Request</a></li>
              <%
                  }
              %>
           </ul>
            <%
                }
            %>
           <ul class="nav navbar-nav navbar-right">
	           <form class="navbar-form navbar-right" method="post">
	            <div class="form-group">
	              <input type="text" name="name" placeholder="Firstname" class="form-control" <%=(logic!= null ? ("value=" + logic.getUser().getName()) : "")%>>
	            </div>
                   <%
                       if(logic==null){
                   %>
               <div class="form-group">
                   <input type="text" name="postcode" placeholder="Postcode" class="form-control" >
               </div>

	            <span class="label label-default">Login as:</span>
	            <button type="submit" class="btn btn-primary" name="type" value="citizen">Citizen</button>
	            <button type="submit" class="btn btn-primary" name="type" value="politician">Politician</button>
                   <%
                       }
                   %>
	          </form>

           </ul>
        </div><!--/.nav-collapse -->
      </div>
  </nav>
  <img alt="Startlogo" src="img/startlogo.jpg" class="stimg">
  <div class="container">
  <!-------------------------CONTENT LOAD ---------------------------->
	<div class="row">
        <div class="col-md-4">
          <h2>CONNECT</h2>
          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
        </div>
        <div class="col-md-4">
          <h2>COLLABORATE</h2>
          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
       </div>
        <div class="col-md-4">
          <h2>CREATE</h2>
          <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
        </div>
      </div>

  <!-------------------------CONTENT LOAD END------------------------->
	  <footer class="footerup">
	  	<p>2016 Citizen , HACKATHON ACCENTURE </p>
	  </footer>
  </div>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  </body>
</html>
