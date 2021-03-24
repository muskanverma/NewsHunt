<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.16/angular.min.js"></script>
        
        <script>
        	var m =angular.module("newshunt",[]);
        	m.controller("userController",function($scope,$http){
        		 $scope.userListData = function(){
        			 $http.post("InitialMenu").then(function(resp){
         				
         				$scope.menuData = resp.data;
         				
         			});
        			 
        			 $http.post("usrLst").then(function(resp){
          				
          				$scope.userData = resp.data;
          				
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
            
        </style>
    </head>
    <body ng-app = "newshunt">
        <div ng-controller="userController" ng-init="userListData()">
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container_fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="adminhome">NewsHunt</a>
                </div>
                <ul class="nav navbar-nav">
                    <li></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#">admin@123</a></li>
                </ul>
            </div>
        </nav>
        
        <div class="sidenav" >
            <div ng-repeat = "x in menuData">
            	<a href="{{x.url}}">{{x.name}}</a>
            </div>
        </div>
        <div class="main">
         	 <div class="table-responsive">          
                  <table class="table table-bordered">
                    <thead>
                      <tr>
                        <th>Email ID</th>
                        <th>Name</th>
                        <th>Phone No</th>
                        <th>Channels subscribed</th>
                      </tr>
                    </thead>
                    <tbody>
                     <tr ng-repeat="x in userData">
                        <td>{{x.email}}</td>
                        <td>{{x.name}}</td>
                        <td>{{x.phone}}</td>
                        <td>{{x.mychannel}}</td>
					</tr>
                    </tbody>
                  </table>
               </div>
        	</div>
        </div>
    </body>
</html>