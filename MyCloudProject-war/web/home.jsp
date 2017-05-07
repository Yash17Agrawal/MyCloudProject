<!DOCTYPE html>
<html>
<head>
	<title>Homepage</title>

	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<nav class="navbar navbar-inverse"  >

<div class="container-fluid">
	
	<!--logo-->
	<div class="navbar-header">
	<a href="http://localhost:24807/MyCloudProject-war/contactus.html" class="navbar-brand" style="cursor: pointer;">My Bank</a>
	</div>

	<!--nav items-->
	<div>
		<ul class="nav navbar-nav">
			
			<li ><a data-toggle="modal" data-target="#popUpTransferMoney" style="cursor: pointer;">Transfer Money</a></li>
			<li ><a data-toggle="modal" data-target="#popUpCreateAccount" style="cursor: pointer;">Create Account</a></li>
                        <li class="dropdown">
                            <a class="dropdown-toogle" data-toggle="dropdown">My Accounts</a>
                            <ul class="dropdown-menu">
				<li ><a href="http://localhost:24807/MyCloudProject-war/Profile">Settings</a></li>				
                            </ul>
                        </li>

			
		</ul>
			<!--dripdown menu-->
			<ul class="nav navbar-nav navbar-right">
			<li ><a href="http://localhost:24807/MyCloudProject-war/contactus.html">Contact Us</a></li>
				<li class="dropdown">
					<a href="#" class="dropdown-toogle" data-toggle="dropdown">My Profile <span class="caret"> </span></a>
					<ul class="dropdown-menu">
						<li ><a href="http://localhost:24807/MyCloudProject-war/Profile">Settings</a></li>
						<li ><a href="#">View History</a></li>
						<li ><a href="http://localhost:24807/MyCloudProject-war/Logout">Logout</a></li>					
					</ul>
				</li>	
			</ul>
			
		
	</div>
</div>

</nav>



<div class="modal fade" id="popUpTransferMoney">
		<div class="modal-dialog">
			<div class="modal-content">
				<!--header-->
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h2 class="modal-title">Fill the transfer details.</h2>
				</div>

				<!--body-->
				<div class="modal-body">
                                    <form role="form" action="http://localhost:24807/MyCloudProject-war/Transaction" method="post">
				
						

						<div class="form-group">
							<input type="text" name="userId" class="form-control" placeholder="Enter receiver's id.">
						</div>						

						<div class="form-group">
							<input type="number" name="amount" class="form-control" placeholder="amount">
						</div>						

				<div class="modal-footer">
                                    <button class="btn btn-primary btn-block" type="submit">Tranfer</button>
				</div>
	

					</form>
				</div>


				<!--footer-->
			
			</div>
		</div>
		
	</div>
    
<div class="modal fade" id="popUpCreateAccount">
		<div class="modal-dialog">
			<div class="modal-content">
				<!--header-->
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h2 class="modal-title">Fill the New Account details.</h2>
				</div>

				<!--body-->
				<div class="modal-body">
                                    <form role="form" action="http://localhost:24807/MyCloudProject-war/createAccount" method="post">
				
						
                                            <div class="form-group">
                                                <input type="radio" name="account_type" value="savings" checked> Savings<br>
                                                <input type="radio" name="account_type" value="current"> Current <br>
                                            </div>
						<div class="form-group">
                                                <input type="text" name="account_pin"  maxlength="4" class="form-control"  placeholder="Enter the 4 digit PIN" required>
						</div>						

						<div class="form-group">
                                                <input type="number" name="initial_amount" class="form-control" placeholder="Initial Amount">
                                    		</div>						

				<div class="modal-footer">
                                    <button class="btn btn-primary btn-block" type="submit">Create Account</button>
				</div>
					</form>
				</div>


				<!--footer-->
			
			</div>
		</div>
		
	</div>
<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
    <li data-target="#myCarousel" data-slide-to="3"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <img src="banls/bank.jpg" alt="Chania" class="img-responsive">
    </div>

    <div class="item">
      <img src="banls/bank2.jpg" alt="Chania" class="img-responsive">
    </div>

    <div class="item">
      <img src="banls/images.jpg" alt="Flower" class="img-responsive">
    </div>

   
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>


</body>
</html>