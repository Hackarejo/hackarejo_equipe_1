package sutil.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import sutil.vo.ItensVO;
import sutil.vo.VendaVO;
import br.edu.unisep.hibernate.DAOGenerico;
import br.edu.unisep.hibernate.HibernateSessionFactory;

public class ItensDAO extends DAOGenerico<ItensVO> {

	public List<ItensVO> listarItens(VendaVO venda) {

		List<ItensVO> listaItens = null;

		Session session = HibernateSessionFactory.getSession();

		SQLQuery q = session
				.createSQLQuery("select * from itens q where q.venda = ?");

		q.addEntity(ItensVO.class);

		q.setInteger(0, venda.getId());

		listaItens = q.list();

		session.close();
		return listaItens;
	}
}