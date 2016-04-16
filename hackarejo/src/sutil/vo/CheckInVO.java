package sutil.vo;

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
@Table(name = "check_in")
public class CheckInVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "estabelecimento")
	private EstabalecimentoVO estabelecimento;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cliente")
	private UsuarioVO cliente;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EstabalecimentoVO getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(EstabalecimentoVO estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public UsuarioVO getCliente() {
		return cliente;
	}

	public void setCliente(UsuarioVO cliente) {
		this.cliente = cliente;
	}

}