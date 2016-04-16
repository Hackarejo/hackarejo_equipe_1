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
@Table(name = "vendas")
public class VendaVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cliente")
	private UsuarioVO cliente;

	@Column(name = "data")
	private Date data;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "estabelecimento")
	private EstabalecimentoVO estabelecimento;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario")
	private UsuarioVO usuario;

	private Integer status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UsuarioVO getCliente() {
		return cliente;
	}

	public void setCliente(UsuarioVO cliente) {
		this.cliente = cliente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public EstabalecimentoVO getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(EstabalecimentoVO estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public UsuarioVO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioVO usuario) {
		this.usuario = usuario;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}