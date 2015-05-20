package internetmotors.autorizacao;

import internetmotors.util.DAOFactory;

public class AutorizacaoExibicaoRN {

	private AutorizacaoExibicaoDAO autorizacaoExibicaoDAO;
	
	public AutorizacaoExibicaoRN() {
		this.autorizacaoExibicaoDAO = DAOFactory.criarAutorizacaoExibicaoDAO();
	}
	
	public void salvar(AutorizacaoExibicao autorizacaoExibicao) {
		this.autorizacaoExibicaoDAO.salvar(autorizacaoExibicao);
	}
	
	public void atualizar(AutorizacaoExibicao autorizacaoExibicao) {
		this.autorizacaoExibicaoDAO.atualizar(autorizacaoExibicao);
	}
	
	public AutorizacaoExibicao carregar(Integer codigo){
		return this.autorizacaoExibicaoDAO.carregar(codigo);
	}
	
	public AutorizacaoExibicao buscarUltimaPorUsuarioVeiculo(Integer codUsuario, Integer codVeiculo) {
		return this.autorizacaoExibicaoDAO.buscarUltimaPorUsuarioVeiculo(codUsuario, codVeiculo);
	}
	
}
