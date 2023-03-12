(function () {
    angular
        .module('app', ['ngRoute'])
        .config(config)
        .run(run);

    function config($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'start/start.html',
                controller: 'startController'
            })
            .when('/list', {
                templateUrl: 'list/list.html',
                controller: 'listController'
            })
            .when('/edit_student/:studentId', {
                templateUrl: 'edit/edit_student.html',
                controller: 'editStudentController'
            })
            .when('/create_student', {
                templateUrl: 'create/create_student.html',
                controller: 'createStudentController'
            })
            .otherwise({
                redirectTo: '/'
            });
    }

    function run($rootScope, $http) {
    }
})();

angular.module('app').controller('indexController', function ($rootScope, $scope, $http) {
    const contextPath = 'http://localhost:8189/app';

});