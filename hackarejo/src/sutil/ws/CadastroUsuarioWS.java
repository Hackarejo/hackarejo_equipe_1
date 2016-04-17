package sutil.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import sutil.dao.UsuarioDAO;
import sutil.vo.UsuarioVO;

@Path("/cadastroUsuario")
public class CadastroUsuarioWS {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public UsuarioVO salvar(UsuarioVO usuario) {

		UsuarioDAO dao = new UsuarioDAO();

		ConverteSenhaWS converteSenha = new ConverteSenhaWS();

		long id = 0L;

		if (usuario.getId() != null && usuario.getId() != 0) {
			usuario.setSenha(converteSenha.converte(usuario.getSenha()));
			dao.atualizar(usuario);
		} else {
			usuario.setSenha(converteSenha.converte(usuario.getSenha()));
			id = dao.cadastrar(usuario);
		}
		return usuario;
	}
}