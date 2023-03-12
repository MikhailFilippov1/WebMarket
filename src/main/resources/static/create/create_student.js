angular.module('app').controller('createStudentController', function ($scope, $http, $location) {
    const contextPath = 'http://localhost:8189/app';

    $scope.createStudent = function () {
        if ($scope.new_student == null) {
            alert('Form not filled');
            return;
        }
        $http.post(contextPath + '/students', $scope.new_student)
            .then(function successCallback (response) {
                $scope.new_student = null;
                alert('Student created success');
                $location.path('/list');
            }, function failureCallback (response) {
                console.log(response);
                alert(response.data.messages);
            });
    }
});