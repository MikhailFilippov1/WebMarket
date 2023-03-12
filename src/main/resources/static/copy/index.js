angular.module('app', []).controller('indexController', function ($scope, $http, $location){
    const contextPath = 'http://localhost:8189/app';

    $scope.loadStudents = function () {
        $http.get(contextPath + '/students')
        .then(function(response){
            $scope.studentList = response.data;});
    }

    $scope.navToInfoPage = function(studentId){
              console.log('Переход в окно информации');
                 $location.path('/page/' + studentId);
              }

    $scope.changeAge = function (studentId, delta){
        $http ({
            url: contextPath + '/student/changeAge',
            method: 'GET',
            params: {
                studentId: studentId,
                delta: delta
            }
        }).then(function (response) {
            $scope.loadStudents();
        });
    };

    $scope.deleteStudent = function (studentId){
            $http({
                url: contextPath + '/deleteStudent/' + studentId,
                method: 'GET',
                params: {
                    studentId: studentId
                }
            }).then(function (response){
                $scope.loadStudents();
        });
    };

    $scope.loadStudents();
});



