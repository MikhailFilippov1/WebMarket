angular.module('app').controller('listController', function ($scope, $http, $location) {
    const contextPath = 'http://localhost:8189/app';

    $scope.loadStudents = function () {
        $http.get(contextPath + '/students')
        .then(function(response){
            console.log(response);
            $scope.students = response.data;
        });
    };

    $scope.navToEditStudentPage = function (studentId) {
        $location.path('/edit_student/' + studentId);
    }

    $scope.loadStudents();
});