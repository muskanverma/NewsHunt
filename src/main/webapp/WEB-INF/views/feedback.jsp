<!DOCTYPE html>
<html>
<head>
	<title></title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.16/angular.min.js"></script>
        <script>
        var m = angular.module("newshunt",[]);
        m.controller("feedback",function($scope , $http){
      	  
      	$scope.feedback = function(){
      		
      		data =  {email:$scope.email, subject:$scope.subject ,message:$scope.message};
      	    $http.post("feedbackform",data).then(function(response){
      	    	if(response.data==1){
      	    		
      	    	  alert("Thankyou !");
      	    	}
      	    	
      	    });	
      	
      	}
      	$scope.menubar = function(){
	 		
			 $http.post("menuList").then(function(resp){
				
				$scope.menuData = resp.data;
				
			}); 
			 
			 $http.post("username").then(function(resp){
 				
 				$scope.user = resp.data;        				
				});
			 
		 }
      	  
      	  
        });  
  
        
        </script>
        <style>
		
		.card{
                background-color: rgba(0,0,0,0.5) !important;
                width: 400px;
                height: 370px;
                margin-top: 100px;
                margin-left: 25%;
               
                position: absolute;
            }
            .container{
                align-content:center;
            }
            .card-header{
                position: relative;
                align-content: center;
                text-align: center;
                color: aliceblue;
                font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
                margin-top: 20px;
                font-size: 30px;
            }
            .card-footer{
                position: relative;
                text-align: center;
                color: aliceblue;

            }
		
		.box {
		  border: 2px solid #ccc;
		  background-color: #eee;
		  border-radius: 5px;
		  padding: 16px;
		  margin-top: 70px;
		  margin-left:280px; 
		  margin-right:280px; 
		}
		
		.box::after {
		  content: "";
		  clear: both;
		  display: table;
		}
		
		.box img {
		  float: left;
		  margin-right: 20px;
		  border-radius: 50%;
		}
		
		.box span {
		  font-size: 20px;
		  margin-right: 15px;
		}
		
		  .box {
		      text-align: center;
		  }
		
		  .box img {
		      margin: auto;
		      float: none;
		      display: block;
		  }
		 .sidenav {
		          height: 100%;
		          width: 200px;
		          position: fixed;
		          z-index: 1;
		          top: 0;
		          left: 0;
		          background-color: #111;
		          overflow-x: hidden;
		          padding-top: 80px;
		          }
		
		  .sidenav a {
		  padding: 6px 8px 6px 16px;
		  text-decoration: none;
		  font-size: 16px;
		  color: #818181;
		  display: block;
		  }
		
		  .sidenav a:hover {
		  color: #f1f1f1;
		  }
		  .button{
		  	margin-top: 500px;
		  }
		.main {
            margin-top:70px;
            margin-left: 210px; 
            font-size: 28px; 
            padding: 0px 10px;
            }
            label{
            	margin-left: 15px;
            }
        </style>
</head>
<body ng-app="newshunt">
	<div class="container" ng-controller="feedback" ng-init="menubar()">
		<nav class="navbar navbar-inverse navbar-fixed-top">
	            <div class="container_fluid">
	                <div class="navbar-header">
	                    <a class="navbar-brand" href="home">NewsHunt</a>
	                </div>
	                <ul class="nav navbar-nav">
	                    <li></li>
	                </ul>
	                <ul class="nav navbar-nav navbar-right">
                    <li><a href="userinfo">{{user.email}}</a></li>
	                </ul>
	            </div>
	        </nav>
	        
	        <div class="sidenav" >
	            <div ng-repeat = "x in menuData">
	            	<a href="{{x.url}}">{{x.name}}</a>
	            </div>
	        </div>
		<div class="card">
			<div class="card-header">
				<h1>FEEDBACK FORM</h1>
				<br>

			</div>
			<div class="card-body">
				<form>
					<label>Email: &nbsp; <input type="email" ng-model="email"></label>
					<br>
					<br> 
					<label>Subject: &nbsp; <input type="text" ng-model="subject"></label>
					<br>
					<br>
					<label> Message: &nbsp; <textarea  rows="5"  name="message" ng-model="message"></textarea></label>
					<br>
					<br>
					<br>
					<button type="button" class="btn btn-success" ng-click="feedback()">SUBMIT</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>