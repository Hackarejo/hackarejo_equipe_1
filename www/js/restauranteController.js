app.controller('RestauranteController', function($scope, $http, $location, $rootScope) {
	
	if($rootScope.restaurante != undefined) {
		$scope.restaurante = $rootScope.restaurante;
		console.log($scope.restaurante);
	}
	
	
});
