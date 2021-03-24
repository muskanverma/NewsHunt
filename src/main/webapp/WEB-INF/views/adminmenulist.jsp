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
        		 $scope.menuListData = function(){
        			 $http.post("InitialMenu").then(function(resp){
         				
         				$scope.menuData = resp.data;
         				
         			});
        			 
        			 $http.post("fetchMenuList").then(function(resp){
          				
          				$scope.menuList = resp.data;
          				
          			});
        		 }
        		 $scope.updatemenu = function(recordSelected){
        			 
        			 $scope.rec = recordSelected;
        			 $('#myModal').modal('show');
        			 
        		 }
        		 $scope.saveUpdateInfo = function(rec){
        			 $http.post("updateMenuInfo",rec).then(function(resp)
         			 		{
         	 					if(resp.data==1)
         	 					{
         	 						alert("Details changed");
         	 					}
         	 				}); 
        		 }
        		
        		 $scope.deletemenu = function(record){
        			 
        			 $http.post("deleteMenuInfo",record).then(function(resp)
          			 		{
          	 					if(resp.data==1)
          	 					{
          	 						alert("Record deleted !");
          	 					}
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
        <div ng-controller="MenuController" ng-init="menuListData()">
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
         	 <div class="table-responsive">          
                  <table class="table table-bordered">
                    <thead>
                      <tr>
                        <th>Flag</th>
                        <th>MenuID</th>
                        <th>MenuName</th>
                        <th>URL</th>
                        <th colspan="2">ACTION</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr ng-repeat="x in menuList">
                        <td>1</td>
                        <td>{{x.id}}</td>
                        <td>{{x.name}}</td>
                        <td>{{x.url}}</td>
                        <td><button class="btn btn-small btn-success" ng-click="updatemenu(x)">UPDATE</button></td>
                        <td><button class="btn btn-small btn-danger" ng-click="deletemenu(x)">DELETE</button></td>
	                         <div class="modal" id="myModal">
							    <div class="modal-dialog">
							      <div class="modal-content">
							      
							        <!-- Modal Header -->
							        <div class="modal-header">
							          <h4 class="modal-title">Upade Record</h4>
							          <button type="button" class="close" data-dismiss="modal">&times;</button>
							        </div>
							        
							        <!-- Modal body -->
							        <div class="modal-body">
							          name <input type = "text" ng-model="rec.name"/>
							          url <input type = "text" ng-model="rec.url"/>
							        </div>
							        
							        <!-- Modal footer -->
							        <div class="modal-footer">
							        <button type="button" class="btn btn-danger" ng-click="saveUpdateInfo(rec)">update</button>
							          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
							        </div>
							        
							      </div>
							    </div>
							  </div>
  
                        
                        
                      </tr>
                    </tbody>
                  </table>
               </div>
        	</div>
        </div>
    </body>
</html>