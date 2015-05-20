package internetmotors.autorizacao;

import org.hibernate.*;

public class AutorizacaoExibicaoDAOHibernate implements AutorizacaoExibicaoDAO {

	private Session session;
	
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(AutorizacaoExibicao autorizacaoExibicao) {
		this.session.save(autorizacaoExibicao);
	}
	
	@Override
	public void atualizar(AutorizacaoExibicao autorizacaoExibicao) {
		this.session.update(autorizacaoExibicao);
	}
	
	@Override
	public AutorizacaoExibicao carregar(Integer codigo) {
		return (AutorizacaoExibicao) this.session.get(AutorizacaoExibicao.class, codigo);
	}
	
	@Override
	public AutorizacaoExibicao buscarUltimaPorUsuarioVeiculo(Integer codUsuario,
			Integer codVeiculo) {
		String hql = "select a from AutorizacaoExibicao a where a.veiculo = :codVeiculo and a.usuario = :codUsuario and a.data=(select MAX(e.data) from AutorizacaoExibicao e where e.veiculo = :codVeiculo and e.usuario = :codUsuario)";
		Query consulta = this.session.createQuery(hql);
		consulta.setInteger("codVeiculo", codVeiculo);
		consulta.setInteger("codUsuario", codUsuario);
		return (AutorizacaoExibicao) consulta.uniqueResult();
	}

}
