app.controller('PainelController', function($scope, $http, $location, $rootScope) {
	$http.get("http://172.40.0.63:8080/hackarejo/ws/listarEstabelecimentos").then(function(value) {
		$scope.listaEstabelecimentos = value.data;
	});

	$scope.abrirRestaurante = function(restaurante) {
		$rootScope.restaurante = restaurante;
		$location.path("/restaurante");
	};
});
