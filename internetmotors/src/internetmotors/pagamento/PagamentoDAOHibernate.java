package internetmotors.pagamento;

import internetmotors.autorizacao.AutorizacaoExibicao;
import internetmotors.usuario.Usuario;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class PagamentoDAOHibernate implements PagamentoDAO {

	private Session session;
	
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(Pagamento pagamento) {
		this.session.save(pagamento);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pagamento> listaPagamentosPorUsuario(Usuario usuario) {
		
		Criteria criteria = this.session.createCriteria(Pagamento.class);
		criteria.add(Restrictions.eqOrIsNull("usuario", usuario));
		return criteria.list();
		
	}

	@Override
	public Pagamento buscarPorAutorizacao(Integer codAutorizacaoExibicao) {
		String hql = "select p from Pagamento p where p.autorizacaoExibicao = :codAutorizacaoExibicao";
		Query consulta = this.session.createQuery(hql);
		consulta.setInteger("codAutorizacaoExibicao", codAutorizacaoExibicao);
		consulta.setMaxResults(1);
		return (Pagamento) consulta.uniqueResult();
	}

}
