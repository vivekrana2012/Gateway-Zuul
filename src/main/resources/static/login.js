//var app = angular.module("app" , ['ngRoute']).config(['$routeProvider', function($routeProvider){
//    $routeProvider
//    .when('/',{
//        template:"<h1>Login</h1>
//                      <form>
//                      <table>
//                          <tr>
//                              <td>User:</td>
//                              <td><input ng-model="username" type="text" name="username" value=""></td>
//                          </tr>
//                          <tr>
//                              <td>Password:</td>
//                              <td><input ng-model="password" type="password" name="password" /></td>
//                          </tr>
//                          <tr>
//                              <td><input ng-click="submit()" name="submit" type="submit" value="submit" /></td>
//                          </tr>
//                      </table>
//                  </form>",
//        controller: 'application_controller'
//        })
//    .when('/computers',{template:'This is the computers Route'})
//    .when('/printers',{template:'This is the printers Route'})
//    .otherwise({redirectTo:'/'});
//    }]);

var app = angular.module("app", []);

app.controller("application_controller", function($scope, $http){

    $scope.username = "";
    $scope.password = "";

    $scope.submit = function(){
        $http.defaults.headers.common['Authorization'] = 'Basic ' + btoa($scope.username + ':' + $scope.password);
        $http.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

        $http.get('/home').then(function(response){
            console.log(response);
            document.open()
            document.write(response.data);
            document.close();
        });
    };

});
