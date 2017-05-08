<%@page import="SessionBeans.UserdataFacadeLocal"%>
<%@page import="javax.ejb.EJB"%>
<!DOCTYPE html>
<html>
<head>
	<title>
		Settings		
	</title>

<%! 
    @EJB 
    UserdataFacadeLocal objyash;
%>
	<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style type="text/css">

  p {font-size: 16px;}

  .margin {margin-bottom: 45px;}
  	
  	.bg-1 { 
      background-color: #1abc9c; /* Green */
      color: #ffffff;
  }


   .bg-2 { 
      background-color: #474e5d; /* Dark Blue */
      color: #ffffff;
      padding-bottom: 30px;
  }


  .bg-4 { 

      background-color: #2f2f2f; /* Black Gray */
      color: #fff;
  }

  </style>

</head>

<body>

<div class="container-fluid bg-1 text-center">
  
  <img src="user1.png" class="img-responsive img-circle margin" style="display:inline" alt="Bird" width="320" height="300">
  <%System.out.println((String)session.getAttribute("userId")+"wow"); %>
  <h3><% if(objyash == null )
      System.out.println("null yash");
  else
      System.out.println("ok ");
//objgetname((String)session.getAttribute("userId"))%></h3>
  <!--<%//obj.getname((String)session.getAttribute("userId"));%>-->
</div>


<div class="container-fluid bg-2 text-center">
  <h3 class="margin" id="about">Change your profile information.</h3>
  <p>Note: Please contact the bank if you see any discrepancies.</p>
 <a href="http://localhost:24807/MyCloudProject-war/contactus.html" class="btn btn-default btn-lg">
    <span class="glyphicon glyphicon-search"></span> CONTACT</a>
</div>

<div class="container-fluid bg-4 text-center">
	
    <form action="http://localhost:24807/MyCloudProject-war/Profile" method="POST">	
<div class="form-group">
  <label for="usr">Current Password</label>
  <input type="password" class="form-control" name="current_pwd">
</div>
<div class="form-group">
  <label for="pwd">New Password</label>
  <input type="password" class="form-control" name="new_pwd">
</div>
        <button class="glyphicon glyphicon-search" type="submit">SUBMIT<br><br></button> 
    
 </form>
<!--<div class="form-group">
  <label for="pwd">Confirm Password</label>
  <input type="password" class="form-control" id="confirm_new_pwd">
</div>-->

<!--<a href="http://localhost:24807/MyCloudProject-war/Profile" class="btn btn-default btn-lg">
    <span class="glyphicon glyphicon-search"></span> 
    SUBMIT
</a>-->
</div>
</body>


</html>