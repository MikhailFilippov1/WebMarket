angular.module('app').controller('editStudentController', function ($scope, $http, $routeParams, $location) {
    const contextPath = 'http://localhost:8189/app';

    $scope.prepareStudentForUpdate = function () {
        $http.get(contextPath + '/students/' + $routeParams.studentId)
            .then(function successCallback (response) {
                $scope.updated_student = response.data;
            }, function failureCallback (response) {
                console.log(response);
                alert(response.data.messages);
                $location.path('/list');
            });
    }

    $scope.updateStudent = function () {
        $http.put(contextPath + '/students', $scope.updated_student)
            .then(function successCallback (response) {
                $scope.updated_student = null;
                alert('Student changes success');
                $location.path('/list');
            }, function failureCallback (response) {
                alert(response.data.messages);
            });
    }

    $scope.prepareStudentForUpdate();
});