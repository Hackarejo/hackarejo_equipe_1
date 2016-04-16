package sutil.ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import sutil.vo.EstabalecimentoVO;
import br.edu.unisep.hibernate.DAOGenerico;

@Path("/listarEstabelecimentos")
public class ListarEstabelecimentosWS {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<EstabalecimentoVO> listarEstabelecimentos() {

		DAOGenerico<EstabalecimentoVO> dao = new DAOGenerico<EstabalecimentoVO>();

		List<EstabalecimentoVO> lista = dao.listar(EstabalecimentoVO.class);

		return lista;
	}
}