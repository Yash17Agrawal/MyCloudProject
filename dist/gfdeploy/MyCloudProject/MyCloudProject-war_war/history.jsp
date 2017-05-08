<%@page import="java.util.List"%>
<%@page import="java.lang.String"%>
<%@page import="java.util.ArrayList"%>
<%@page import="SessionBeans.TransactionTableFacadeLocal"%>
<%@page import="javax.ejb.EJB"%>
<!DOCTYPE html>
<html>
<head>
	<title>
		Transaction history
	</title>

	<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 
  <%!
     @EJB
  TransactionTableFacadeLocal obj;%>
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


  .bg-3 { 
      background-color: #ffffff; /* Dark Blue */
      color: #000000;
      margin: 10px;
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
  <h3>USER NAME</h3>
</div>

<div class="container-fluid bg-2 text-center">
  <h3 class="margin" id="about">Transaction History</h3>
  <p>Note: Please contact the bank if you see any discrepancies.</p>
 <a href="###########################LINK FOR CONTACT PAGE###############" class="btn btn-default btn-lg">
    <span class="glyphicon glyphicon-search"></span> CONTACT</a>
</div>


<!-- FOR HEADING -->
<div class="container-fluid bg-4 text-center">
	
	<div class="row">
		<div class="col-md-3" > FROM</div>
		<div class="col-md-3" > TO</div>
		<div class="col-md-3" > AMOUNT</div>
		<div class="col-md-3" > DATE</div>
	</div>

</div>


<!-- HERE YOU'LL APPLY FOR LOOP WITH THE DETAILS FILLED IN-->

<div class="container-fluid bg-3 text-center">
	<%/*int id=Integer.parseInt((String)request.getSession().getAttribute("userId"));
            obj.
            ArrayList<ArrayList<String>> arlist=new ArrayList<ArrayList<String>>(obj.trasactionHistory(id));*/
           // for(ArrayList temp:new ArrayListrequest.getAttribute("arlist"))
            //{
              //  System.out.println(temp);*/
            
    %>
        <% 
           for(ArrayList<String> temp:(ArrayList<ArrayList<String>>)request.getAttribute("arlist"))
           {
               
        %>
	<div class="row">
		<div class="col-md-3" ><%=temp.get(0)%> </div>
                <div class="col-md-3" ><%=temp.get(1)%></div>
		<div class="col-md-3" ><%=temp.get(2)%> </div>
		<div class="col-md-3" > <%=temp.get(3)%></div>
	</div>
        <% } %>
             
</div>

<!-- END OF LOOP-->

<div class="container-fluid bg-4 text-center">    
 




</body>


</html>