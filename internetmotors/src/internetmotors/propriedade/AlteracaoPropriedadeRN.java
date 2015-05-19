package internetmotors.propriedade;

import java.util.*;

import internetmotors.util.DAOFactory;
import internetmotors.usuario.Usuario;
import internetmotors.veiculo.Veiculo;
import internetmotors.veiculo.VeiculoRN;

public class AlteracaoPropriedadeRN {

	private AlteracaoPropriedadeDAO alteracaoPropriedadeDAO;
	
	public AlteracaoPropriedadeRN() {
		this.alteracaoPropriedadeDAO = DAOFactory.criarAlteracaoPropriedadeDAO();
	}
	public void atualizar(AlteracaoPropriedade alteracaoPropriedade){
		
		this.alteracaoPropriedadeDAO.atualizar(alteracaoPropriedade);
		
	}
	public void atualizarAceite(AlteracaoPropriedade alteracaoPropriedade, Usuario novoProprietario) {
		
		//Atualiza o novo proprietário no veículo 
		VeiculoRN veiculoRN = new VeiculoRN();
		Veiculo veiculoNovoProprietario = new Veiculo();
		veiculoNovoProprietario = alteracaoPropriedade.getOcorrencia().getVeiculo();
		veiculoNovoProprietario.setUsuario(novoProprietario);
		veiculoNovoProprietario.setDataModificacao(new Date());
		veiculoRN.atualizar(veiculoNovoProprietario);
		
		//Atualiza o status da alteração como aceito
		this.alteracaoPropriedadeDAO.atualizar(alteracaoPropriedade);
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
