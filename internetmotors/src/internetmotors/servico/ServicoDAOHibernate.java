package internetmotors.servico;

import java.util.List;
import org.hibernate.*;

public class ServicoDAOHibernate implements ServicoDAO {

	private Session session;
	
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(Servico servico) {
		this.session.save(servico);

	}

	@Override
	public void atualizar(Servico servico) {
		this.session.update(servico);
	}

	@Override
	public void excluir(Servico servico) {
		this.session.delete(servico);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Servico> listar() {
		return this.session.createCriteria(Servico.class).list();
	}

}
