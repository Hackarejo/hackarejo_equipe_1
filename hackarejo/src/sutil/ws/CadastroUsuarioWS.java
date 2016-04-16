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

		ConverteSenhaWS converteSenha = new ConverteSenhaWS();

		if (usuario.getId() != null && usuario.getId() != 0) {
			usuario.setSenha(converteSenha.converte(usuario.getSenha()));
			dao.atualizar(usuario);
		} else {
			usuario.setSenha(converteSenha.converte(usuario.getSenha()));
			dao.salvar(usuario);
		}
	}
}