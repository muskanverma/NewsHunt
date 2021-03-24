<html>
    <head>
        <title>Home page</title>
        <title>Login</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.16/angular.min.js"></script>
        
        <script>
        	var m =angular.module("newshunt",[]);
        	m.controller("MenuController",function($scope,$http){
        		 $scope.menuData = function(){
        			$http.post("InitialMenu").then(function(resp){
        				
        				$scope.menuData = resp.data;
        				
        			});
        			
					$http.post("username").then(function(resp){
        				
        				$scope.user = resp.data;        				
    				});
        			
        			$http.post("ttusers").then(function(resp){
        				
        				$scope.totalusers = resp.data;
        				
        			});
        			
        			$http.post("ttchannels").then(function(resp){
        				
        				$scope.totalchannels = resp.data;
        			});
        			
        			$http.post("sub").then(function(resp){
        				
        				$scope.subscribedchannels = resp.data;
        				
        			});
        			
        			 $http.post("unsub").then(function(resp){
        				
        				$scope.unsubscribedchannels = resp.data;
        			});
       			 }
        	        	
        	});	
       </script>
       
        <style>
            body {
            font-family: "Lato", sans-serif;
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

            .main {
            margin-top:70px;
            margin-left: 210px; 
            font-size: 28px; 
            padding: 0px 10px;
            }
            table{
            border: 1px solid black;
            
            }
        </style>
    </head>
    <body ng-app = "newshunt">
        <div ng-controller="MenuController" ng-init="menuData()">
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container_fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="adminhome">NewsHunt</a>
                </div>
                <ul class="nav navbar-nav">
                    <li></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#">{{user}}</a></li>
                </ul>
            </div>
        </nav>
        
        <div class="sidenav" >
            <div ng-repeat = "x in menuData">
            	<a href="{{x.url}}">{{x.name}}</a>
            </div>
        </div>
        <div class="main">
        
        	<table>
        		<tr>
        			<th>TOTAL USERS</th>
        			<th>TOTAL CHANNELS</th>
        			<th>SUBSCRIBED CHANNELS</th>
        			<th>UNSUBSCRIBED CHANNELS</th>
 				</tr>
 				<tr>
 					<td>{{totalusers}}</td>
 					<td>{{totalchannels}}</td>
 					<td>{{subscribedchannels}}</td>
 					<td>{{unsubscribedchannels}}</td>
 					
				</tr>
        	</table>
        	
          
        </div>
        </div>
    </body>
</html>