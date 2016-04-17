package sutil.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import sutil.vo.VendaVO;
import br.edu.unisep.hibernate.DAOGenerico;

@Path("/chekInWS")
public class CheckInWS {

	private VendaVO venda;

	DAOGenerico<VendaVO> dao = new DAOGenerico<VendaVO>();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/criarVenda")
	public void criarVenda() {
		venda.setStatus(0);
		dao.salvar(venda);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/atualizarStatus")
	public void atualizarStatus(VendaVO venda) {
		dao.atualizar(venda);
	}
}