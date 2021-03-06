package sutil.dao;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import sutil.vo.UsuarioVO;
import br.edu.unisep.hibernate.DAOGenerico;
import br.edu.unisep.hibernate.HibernateSessionFactory;

public class UsuarioDAO extends DAOGenerico<UsuarioVO> {

	public UsuarioVO login(UsuarioVO usuario) {

		List<UsuarioVO> ok = null;

		Session session = HibernateSessionFactory.getSession();

		SQLQuery q = session
				.createSQLQuery("select * from usuarios q where q.email = ? and q.senha = ?");

		q.addEntity(UsuarioVO.class);

		q.setString(0, usuario.getEmail());
		q.setString(1, usuario.getSenha());

		ok = q.list();

		session.close();

		if (ok.isEmpty()) {
			return ok.get(0);
		} else {
			return ok.get(0);
		}
	}

	public long cadastrar(UsuarioVO usuario) {
		Session session = HibernateSessionFactory.getSession();

		Transaction trans = session.beginTransaction();
		long result = 0L;
		try {
			session.save(usuario);

			trans.commit();

		} catch (Exception e) {
			trans.rollback();
		}
		session.close();

		return result;
	}
}