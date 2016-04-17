var app = angular.module('app', [ "ngRoute"]);

app.config(function($routeProvider) {
	$routeProvider.when("/painel", { 
		templateUrl : "painel.html",
		controller : "PainelController" 
	}).when("/cadastrarUsuario", {
		templateUrl : "cadastro-usuario.html",
		controller : "CadastroUsuarioController"
	}).when("/login", {
		templateUrl : "login.html",
		controller : "LoginController"
	}).when("/termo", {
		templateUrl : "termos.html"
	}).when("/restaurante", {
		templateUrl : "nome-restaurante.html",
		controller : "RestauranteController"
	}).otherwise({
		redirectTo : "/login"
	});
});

app.controller('AppController', function($scope, $http, $location) {

});

app.controller('LoginController', function($scope, $http, $location) {
 	$scope.telaLogin = false;
	$scope.login = new UsuarioVO();
	$scope.logar = function() {
		var ws = $http.post("http://172.40.0.63:8080/hackarejo/ws/login", $scope.login);
		ws.success(function(data) {
			if (data == '') {
				console.log("Email ou senhas incorretos")
			} else {
				$location.path("/painel");
			}
		});

		ws.error(function(data, status) {
			console.log("Erro ao Executar login. status " + status);
			$location.path("/painel");
		});
	}

});