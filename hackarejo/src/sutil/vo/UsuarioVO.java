package sutil.vo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class UsuarioVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "sobrenome")
	private String sobrenome;

	@Column(name = "email")
	private String email;

	@Column(name = "senha")
	private String senha;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "dt_nascimento")
	private Date nascimento;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "estabelecimento")
	private EstabalecimentoVO estabelecimento;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "papel")
	private PapelVO papel;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public EstabalecimentoVO getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(EstabalecimentoVO estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public PapelVO getPapel() {
		return papel;
	}

	public void setPapel(PapelVO papel) {
		this.papel = papel;
	}

}