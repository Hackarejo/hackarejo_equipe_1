package sutil.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import sutil.vo.UsuarioVO;
import br.edu.unisep.hibernate.DAOGenerico;

@Path("/cadastroUsuario")
public class CadastroUsuarioWS {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void salvar(UsuarioVO usuario) {

		DAOGenerico<UsuarioVO> dao = new DAOGenerico<UsuarioVO>();

		if (usuario.getId() != null && usuario.getId() != 0) {
			dao.atualizar(usuario);
		} else {
			dao.salvar(usuario);
		}
	}
}