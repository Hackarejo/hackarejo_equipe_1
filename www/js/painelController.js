app.controller('PainelController', function($scope, $http, $location) {
	$http.get("http://172.40.0.63:8080/hackarejo/ws/listarEstabelecimentos").then(function(value) {
		$scope.listaEstabelecimentos = value.data;
	});
});
