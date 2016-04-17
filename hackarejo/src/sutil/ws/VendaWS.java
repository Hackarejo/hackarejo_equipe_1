package sutil.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import sutil.dao.ItensDAO;
import sutil.vo.ItensVO;
import sutil.vo.VendaVO;
import br.edu.unisep.hibernate.DAOGenerico;

@Path("/vendaWS")
public class VendaWS {

	DAOGenerico<VendaVO> daoVenda = new DAOGenerico<VendaVO>();
	DAOGenerico<ItensVO> daoItens = new DAOGenerico<ItensVO>();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/atualizarVenda")
	public void atualizarVenda(VendaVO venda) {
		daoVenda.atualizar(venda);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/adicionarItens")
	public void adicionarItem(List<ItensVO> itens) {

		for (ItensVO iten : itens) {

			if (iten.getId() != 0 || iten.getId() != null) {
				daoItens.atualizar(iten);
			} else {
				daoItens.salvar(iten);
			}
		}
	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listarVendas")
	public List<VendaVO> listarVendas() {

		DAOGenerico<VendaVO> dao = new DAOGenerico<VendaVO>();

		List<VendaVO> listaVendas = dao.listar(VendaVO.class);

		return listaVendas;
	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listarItensVendas")
	public List<ItensVO> listarItens(VendaVO venda) {

		ItensDAO dao = new ItensDAO();

		List<ItensVO> listaItens = dao.listarItens(venda);

		return listaItens;
	}
}