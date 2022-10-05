angular.module('app1', []).controller('indexController1', function ($scope, $http){
    const contextPath = 'http://localhost:8189/app';

    $scope.loadProductById = function (productId) {
        $http({
        url: contextPath + '/product/' + productId,
                    method: 'GET',
                    params: {
                        productId: productId
                        }
        })
        .then(function (response) {
            $scope.product = response.data;
        });
    }

});