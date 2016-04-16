package sutil.ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import sutil.vo.ClienteVO;
import br.edu.unisep.hibernate.DAOGenerico;

@Path("/listarClientes")
public class ListarClientesWS {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ClienteVO> listarClientes() {

		DAOGenerico<ClienteVO> dao = new DAOGenerico<ClienteVO>();

		List<ClienteVO> lista = dao.listar(ClienteVO.class);

		return lista;
	}
}