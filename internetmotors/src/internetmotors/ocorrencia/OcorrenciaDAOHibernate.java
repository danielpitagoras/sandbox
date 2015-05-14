package internetmotors.ocorrencia;


import internetmotors.veiculo.Veiculo;

import java.util.List;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

public class OcorrenciaDAOHibernate implements OcorrenciaDAO {
	
	private Session session;
	
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(Ocorrencia ocorrencia) {
		this.session.save(ocorrencia);

	}

	@Override
	public void atualizar(Ocorrencia ocorrencia) {
		this.session.update(ocorrencia);

	}

	@Override
	public void excluir(Ocorrencia ocorrencia) {
		this.session.delete(ocorrencia);

	}
	
	@Override
	public Ocorrencia carregar(Integer codigo) {
		return (Ocorrencia) this.session.get(Ocorrencia.class, codigo);
	}

	@Override
	public Ocorrencia buscarUltimaPorVeiculo(Integer codVeiculo) {
		String hql = "select o from Ocorrencia o where o.veiculo = :codVeiculo and o.dataCriacao=(select MAX(v.dataCriacao) from Ocorrencia v where v.veiculo = :codVeiculo)";
		Query consulta = this.session.createQuery(hql);
		consulta.setInteger("codVeiculo", codVeiculo);
		return (Ocorrencia) consulta.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ocorrencia> listarPorVeiculo(Veiculo veiculo) {
		Criteria criteria = this.session.createCriteria(Ocorrencia.class);
		criteria.add(Restrictions.eqOrIsNull("veiculo", veiculo));
		return criteria.list();
	}

}
