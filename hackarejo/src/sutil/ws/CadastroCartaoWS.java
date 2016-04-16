package sutil.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import sutil.vo.CartaoVO;
import br.edu.unisep.hibernate.DAOGenerico;

@Path("/cadastroCartao")
public class CadastroCartaoWS {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void salvar(CartaoVO cartao) {

		DAOGenerico<CartaoVO> dao = new DAOGenerico<CartaoVO>();

		if (cartao.getId() != null && cartao.getId() != 0) {
			dao.atualizar(cartao);
		} else {
			dao.salvar(cartao);
		}
	}
}