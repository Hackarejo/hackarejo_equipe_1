package sutil.ws;

import java.util.List;

import sutil.vo.ProdutoVO;
import br.edu.unisep.hibernate.DAOGenerico;

public class ListarProdutosWS {

	public List<ProdutoVO> listar() {

		DAOGenerico<ProdutoVO> dao = new DAOGenerico<ProdutoVO>();

		List<ProdutoVO> listaProdutos = dao.listar(ProdutoVO.class);

		return listaProdutos;
	}
}