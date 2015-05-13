package internetmotors.veiculo;

import internetmotors.usuario.Usuario;
import internetmotors.veiculo.Veiculo;

import java.util.List;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

public class VeiculoDAOHibernate implements VeiculoDAO {

	private Session session;
	
	
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(Veiculo veiculo) {
		this.session.save(veiculo);
	}

	@Override
	public void atualizar(Veiculo veiculo) {
		this.session.update(veiculo);
	}

	@Override
	public void excluir(Veiculo veiculo) {
		this.session.delete(veiculo);
	}

	@Override
	public Veiculo carregar(Integer codigo) {
		return (Veiculo) this.session.get(Veiculo.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Veiculo> listar() {
		return this.session.createCriteria(Veiculo.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Veiculo> listarPorUsuario(Usuario usuario) {
		Criteria criteria = this.session.createCriteria(Veiculo.class);
		criteria.add(Restrictions.eqOrIsNull("usuario", usuario));
		return criteria.list();
	}
	
	public Veiculo buscarUltimoModificado(Integer codUsuario) {
		String hql = "select v from Veiculo v where v.usuario = :codUsuario and v.dataModificacao=(select MAX(a.dataModificacao) from Veiculo a where a.usuario = :codUsuario)";
		//String hql = "from Veiculo v where v.usuario = :codUsuario order by v.dataModificacao DESC";
		Query consulta = this.session.createQuery(hql);
		consulta.setInteger("codUsuario", codUsuario);
		consulta.setMaxResults(1);
		return (Veiculo) consulta.uniqueResult();	
	
	
	
	}

}
