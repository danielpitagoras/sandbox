package internetmotors.servico;

import java.util.*;
import internetmotors.util.DAOFactory;

public class ServicoRN {
	
	private ServicoDAO servicoDAO;
	
	public ServicoRN() {
		this.servicoDAO = DAOFactory.criarServicoDAO();
	}
	
	public void salvar(Servico servico) {
		this.servicoDAO.salvar(servico);
	}
	
	public void excluir(Servico servico) {
		this.servicoDAO.excluir(servico);
	}
	
	public List<Servico> listar() {
		return this.servicoDAO.listar();
	}

}
