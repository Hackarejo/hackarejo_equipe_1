package sutil.ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import sutil.vo.CartaoVO;
import br.edu.unisep.hibernate.DAOGenerico;

@Path("/listarCartoes")
public class ListarCartoesWS {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CartaoVO> listarCartoes() {

		DAOGenerico<CartaoVO> dao = new DAOGenerico<CartaoVO>();

		List<CartaoVO> lista = dao.listar(CartaoVO.class);

		return lista;
	}
}