package sutil.ws;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import sutil.dao.UsuarioDAO;
import sutil.vo.UsuarioVO;

@Path("/login")
public class LoginWS {

	ConverteSenhaWS converteSenha = new ConverteSenhaWS();
	
	@Context
	private HttpServletRequest request;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response doLogin(UsuarioVO usuario) {

		usuario.setSenha(converteSenha.converte(usuario.getSenha()));
		
		UsuarioDAO dao = new UsuarioDAO();
		
		Integer ok = dao.login(usuario);

		if (ok == 0) {
			Response retorno = null;
			retorno = Response.ok().build();

			request.getSession().setAttribute("LOGADO", "OK");
			return retorno;
		} else {
			Response retorno = null;
			retorno = Response.status(Status.UNAUTHORIZED).build();

			request.getSession().setAttribute("FALHA", "FALHA");
			return retorno;
		}
	}
}