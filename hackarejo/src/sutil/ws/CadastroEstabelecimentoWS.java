package sutil.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import sutil.vo.EstabalecimentoVO;
import br.edu.unisep.hibernate.DAOGenerico;

@Path("/cadastroEstabelecimento")
public class CadastroEstabelecimentoWS {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void salvar(EstabalecimentoVO estabelecimento) {

		DAOGenerico<EstabalecimentoVO> dao = new DAOGenerico<EstabalecimentoVO>();

		if (estabelecimento.getId() != null && estabelecimento.getId() != 0) {
			dao.atualizar(estabelecimento);
		} else {
			dao.salvar(estabelecimento);
		}
	}
}