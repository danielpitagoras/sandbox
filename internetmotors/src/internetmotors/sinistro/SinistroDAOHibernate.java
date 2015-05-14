package internetmotors.sinistro;

import java.util.List;
import org.hibernate.*;

public class SinistroDAOHibernate implements SinistroDAO {

	private Session session;
	
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(Sinistro sinistro) {
		this.session.save(sinistro);
	}

	@Override
	public void atualizar(Sinistro sinistro) {
		this.session.update(sinistro);
	}

	@Override
	public void excluir(Sinistro sinistro) {
		this.session.delete(sinistro);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sinistro> listar() {
		return this.session.createCriteria(Sinistro.class).list();
	}

}
