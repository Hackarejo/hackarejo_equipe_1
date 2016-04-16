package sutil.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import sutil.vo.ClienteVO;
import br.edu.unisep.hibernate.DAOGenerico;

@Path("/cadastroCliente")
public class CadastroClienteWS {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void salvar(ClienteVO cliente) {

		DAOGenerico<ClienteVO> dao = new DAOGenerico<ClienteVO>();

		if (cliente.getId() != null && cliente.getId() != 0) {
			dao.atualizar(cliente);
		} else {
			dao.salvar(cliente);
		}
	}
}