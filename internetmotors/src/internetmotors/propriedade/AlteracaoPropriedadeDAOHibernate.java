package internetmotors.propriedade;

import java.util.List;

import org.hibernate.*;

public class AlteracaoPropriedadeDAOHibernate implements
		AlteracaoPropriedadeDAO {

	
	private Session session;
	
	
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(AlteracaoPropriedade alteracaoPropriedade) {		
		this.session.save(alteracaoPropriedade);
	}

	@Override
	public void atualizar(AlteracaoPropriedade alteracaoPropriedade) {
		this.session.update(alteracaoPropriedade);
	}

	@Override
	public void excluir(AlteracaoPropriedade alteracaoPropriedade) {
		this.session.delete(alteracaoPropriedade);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AlteracaoPropriedade> listar() {
		return this.session.createCriteria(AlteracaoPropriedade.class).list();
	}

}
