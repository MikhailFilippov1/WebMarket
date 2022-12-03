angular.module('app2', []).controller('indexController2', function ($scope, $http){
    const contextPath = 'http://localhost:8189/app';

    $scope.addProduct = function (productId, productTitle, productPrice) {
        $http ({
                    url: contextPath + '/create',
                    method: 'GET',
                    params: {
                        productId: document.getElementById("productId").value, //productId,
                        productTitle: document.getElementById("productTitle").value, //productTitle,
                        productPrice: document.getElementById("productPrice").value //productPrice
                    }
                }).then(function (response) {
                    $location.path('/products');
                });
    }

//    $scope.loadProducts();
});



