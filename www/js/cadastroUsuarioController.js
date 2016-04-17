app.controller('CadastroUsuarioController', function($scope, $http, $location) {
	 $scope.telaLogin = false;
	$scope.usuario = new UsuarioVO();
	$scope.cartao = new CartaoVO();
	$scope.criarUsuario = function() {
		var ws = $http.post("http://172.40.0.63:8080/hackarejo/ws/cadastroUsuario", $scope.usuario);
		ws.success(function(data) {
			if (data == '') {
				console.log("Email ou senhas incorretos")
			} else {
				$scope.cadastrarCartao(data);
			}
		});

		ws.error(function(data, status) {
			console.log("Erro ao Executar login. status " + status);
			
		});
	}

	$scope.cadastrarCartao = function(data) {
		$scope.cartao.usuario = data;
		var ws = $http.post("http://172.40.0.63:8080/hackarejo/ws/cadastroCartao", $scope.cartao);

		ws.success(function(data) {
		if (data == '') {
			$location.path("/login");
		}
		});

		ws.error(function(data, status) {
			console.log("Erro ao Executar login. status " + status);
			
		});
	};
});
