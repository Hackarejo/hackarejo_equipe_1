package sutil.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import sutil.vo.UsuarioVO;
import sutil.vo.VendaVO;
import br.edu.unisep.hibernate.DAOGenerico;
import br.edu.unisep.hibernate.HibernateSessionFactory;

public class VendaDAO extends DAOGenerico<VendaVO> {

	public List<VendaVO> ListarHistorico(UsuarioVO cliente) {

		List<VendaVO> listaVendas = null;

		Session session = HibernateSessionFactory.getSession();

		SQLQuery q = session
				.createSQLQuery("select * from vendas q where q.usuario = ?");

		q.addEntity(VendaVO.class);

		q.setInteger(0, cliente.getId());

		listaVendas = q.list();

		session.close();
		return listaVendas;

	}

}