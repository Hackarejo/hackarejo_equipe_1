package sutil.ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import sutil.vo.UsuarioVO;
import br.edu.unisep.hibernate.DAOGenerico;

@Path("/listarUsuarios")
public class ListarUsuarioWS {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<UsuarioVO> listarUsuarios() {

		DAOGenerico<UsuarioVO> dao = new DAOGenerico<UsuarioVO>();

		List<UsuarioVO> lista = dao.listar(UsuarioVO.class);

		return lista;
	}
}