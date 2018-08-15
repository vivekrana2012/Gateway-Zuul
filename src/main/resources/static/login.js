var app = angular.module("app" , []);
app.controller("application_controller", function($scope, $http){

    $scope.username = "";
    $scope.password = "";

    $scope.submit = function(){
        $http.defaults.headers.common['Authorization'] = 'Basic ' + btoa($scope.username + ':' + $scope.password);

        $http.get('/home').then(function(response){
            console.log(response);
        });
    };

});
