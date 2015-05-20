package internetmotors.autorizacao;


public interface AutorizacaoExibicaoDAO {

	public void salvar(AutorizacaoExibicao autorizacaoExibicao);
	public void atualizar(AutorizacaoExibicao autorizacaoExibicao);
	public AutorizacaoExibicao carregar(Integer codigo);
	public AutorizacaoExibicao buscarUltimaPorUsuarioVeiculo(Integer codUsuario, Integer codVeiculo);
	
}
