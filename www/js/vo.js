function PapelVO() {
	this.id = null;
	this.papel = null;
}

function EnderecoVO() {
	this.id = null;
	this.cidade = null;
	this.rua = null;
	this.numero = null;
	this.complemento = null;
	this.bairro = null;
}

function EstabelecimentoVO() {
	this.id = null;
	this.nome = null;
	this.razaoSocial = null;
	this.cnpj = null;
	this.conta = null;
	this.endereco = new EnderecoVO();
}

function UsuarioVO() {
	this.id = null;
	this.senha = null;
	this.nome = null;
	this.sobrenome = null;
	this.email = null;
	this.cpf = null;
	this.nascimento = null;
	this.estabelecimento = new EstabelecimentoVO();
	this.papel = new PapelVO();
}

