package sutil.ws;

import java.util.List;

import sutil.dao.VendaDAO;
import sutil.vo.UsuarioVO;
import sutil.vo.VendaVO;

public class HistoricoWS {

	public List<VendaVO> listarHistorico(UsuarioVO cliente) {

		VendaDAO dao = new VendaDAO();

		List<VendaVO> historico = dao.ListarHistorico(cliente);

		return historico;
	}
}