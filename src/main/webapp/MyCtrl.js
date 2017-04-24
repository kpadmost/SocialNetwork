
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

app.controller('myCtrl', function($scope, $http, $location, $q) {
    var REST_SERVICE_URI = 'http://localhost:8080/users';

    $scope.user = {firstName: "", surname: "", email: "", password: ""};


    $scope.createUser = function(user)  {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI, $scope.user)
            .then(
                function (response) {

                    deferred.resolve(response.data);

                    $scope.goLogin();
                },
                function(errResponse){
                    console.error('Error while creating User');
                    deferred.reject(errResponse);

                    $scope.goLogin();
                }
            );
        return deferred.promise;
    }

    $scope.goLogin = function() {
        window.location.href="http://localhost:8080/index.html";
    }

    $scope.goRegistration = function() {
        window.location.href="http://localhost:8080/registration.html";
    }

    $http.get('http://localhost:8080/registration.html').
    then(function(response) {
        $scope.greeting = response.data;
    });
});