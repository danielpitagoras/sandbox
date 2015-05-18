package internetmotors.propriedade;

import java.util.*;
import internetmotors.util.DAOFactory;
import internetmotors.usuario.Usuario;

public class AlteracaoPropriedadeRN {

	private AlteracaoPropriedadeDAO alteracaoPropriedadeDAO;
	
	public AlteracaoPropriedadeRN() {
		this.alteracaoPropriedadeDAO = DAOFactory.criarAlteracaoPropriedadeDAO();
	}
	
	public void salvar(AlteracaoPropriedade alteracaoPropriedade) {
		this.alteracaoPropriedadeDAO.salvar(alteracaoPropriedade);
	}
	
	public void excluir(AlteracaoPropriedade alteracaoPropriedade) {
		this.alteracaoPropriedadeDAO.excluir(alteracaoPropriedade);
	}

	public List<AlteracaoPropriedade> listar() {
		return this.alteracaoPropriedadeDAO.listar();
	}
	
	public List<AlteracaoPropriedade> listarPorAlteracao(Usuario usuario){
		return this.alteracaoPropriedadeDAO.listarPorAlteracao(usuario);
	}
	
}
