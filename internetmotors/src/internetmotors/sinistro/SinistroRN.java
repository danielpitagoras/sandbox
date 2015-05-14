package internetmotors.sinistro;

import java.util.*;
import internetmotors.util.DAOFactory;

public class SinistroRN {

	private SinistroDAO sinistroDAO;
	
	public SinistroRN() {
		this.sinistroDAO = DAOFactory.criarSinistroDAO();
	}
	
	public void salvar(Sinistro sinistro) {
		this.sinistroDAO.salvar(sinistro);
	}
	
	public void excluir(Sinistro sinistro) {
		this.sinistroDAO.excluir(sinistro);
	}
	
	public List<Sinistro> listar() {
		return this.sinistroDAO.listar();
	}
}
