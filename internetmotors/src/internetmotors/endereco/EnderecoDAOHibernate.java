package internetmotors.endereco;

import internetmotors.endereco.Endereco;
import internetmotors.usuario.Usuario;

import java.util.List;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

public class EnderecoDAOHibernate implements EnderecoDAO {

	private Session session;
		
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(Endereco endereco) {
		this.session.saveOrUpdate(endereco);
	}

	@Override
	public void atualizar(Endereco endereco) {

	}

	@Override
	public void excluir(Endereco endereco) {
		this.session.delete(endereco);
	}

	@Override
	public Endereco carregar(Integer codigo) {
		return (Endereco) this.session.get(Endereco.class, codigo);	
	}

	@Override
	public Endereco buscarPorDesc(String desc) {
		String hql = "select e from Endereco e where e.descricao = :desc";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("desc", desc);
		return (Endereco) consulta.uniqueResult();
	}

	@Override
	public Endereco buscarPorDescEUsuario(String desc, int codigo) {
		String hql = "select e from Endereco e where e.descricao = :desc and e.codigo = :codigo";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("desc", desc);
		consulta.setInteger("codigo", codigo);
		return (Endereco) consulta.uniqueResult();
	}

	@Override
	public Endereco buscarPorCodigo(int codigo) {
		String hql = "select e from Endereco e where e.codigo = :codigo";
		Query consulta = this.session.createQuery(hql);
		consulta.setInteger("codigo", codigo);
		return (Endereco) consulta.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Endereco> listar() {
		return this.session.createCriteria(Endereco.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Endereco> listarPorUsuario(Usuario usuario) {
		Criteria criteria = this.session.createCriteria(Endereco.class);
		criteria.add(Restrictions.eqOrIsNull("usuario", usuario));
		return criteria.list();
	}
	
	

}
