
var app = angular.module('myApp', []);

app.directive( 'goClick', function ( $location ) {
    return function ( scope, element, attrs ) {
        var path;

        attrs.$observe( 'goClick', function (val) {
            path = val;
        });

        element.bind( 'click', function () {
            scope.$apply( function () {
                $location.path( path );
            });
        });
    };
});

/*ADDRESSES TO CHANGE*/

app.controller('myCtrl', function($scope, $timeout, $http, $location, $q) {
    var REST_SERVICE_URI = 'http://localhost:8080/';

    $scope.user = {firstName: "", surname: "", email: "", password: ""};
    $scope.finishClicked = false;
    $scope.signInClicked = false;
    $scope.userFound = false;
    $scope.userFindError = false;
    $scope.userData = {loginData : "", passData : ""};

    $scope.createUser = function()  {
        $scope.finishClicked = true;
        $http.put(REST_SERVICE_URI+"users", $scope.user)
            .then(
                function (response) {


                    $scope.goLogin();
                }
            );
    }

    $scope.goUser = function() {
        $scope.signInClicked = true;

        $http.put(REST_SERVICE_URI+"login", $scope.user)
            .then(
                function (response) {
                    if(response.data!=-1) {
                        $scope.userFound = true;
                        $scope.userFindError = false;
                        window.location.href=REST_SERVICE_URI+"users/"+response.data;
                        /*$http.get(REST_SERVICE_URI+"users/"+response.data)
                            .then(
                                function (response) {
                                    $scope.goPersonalPage(response.data);
                                }
                            );*/
                    }
                    else{
                        $scope.userFound = false;
                        $scope.userFindError = true;
                        console.error('Error while fetching Users');

                    }
                }
            );
    }

    /*$scope.getData = function () {

    }*/
    $scope.goLogin = function() {
        window.location.href="http://localhost:8080/index.html";
    }

    $scope.goPersonalPage = function(id) {
        window.location.href="http://localhost:8080/personalPage/?i"+id;
    }

    $scope.goRegistration = function() {
        window.location.href="http://localhost:8080/registration.html";
    }

});