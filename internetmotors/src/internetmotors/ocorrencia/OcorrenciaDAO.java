package internetmotors.ocorrencia;

import java.util.List;
import internetmotors.veiculo.Veiculo;

public interface OcorrenciaDAO {

	public void salvar(Ocorrencia ocorrencia);
	public void atualizar(Ocorrencia ocorrencia);
	public void excluir(Ocorrencia ocorrencia);
	public Ocorrencia carregar(Integer codigo);
	public Ocorrencia buscarUltimaPorVeiculo(Integer codVeiculo);
	public List<Ocorrencia> listarPorVeiculo(Veiculo veiculo);
	
}
