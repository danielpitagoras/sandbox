package internetmotors.veiculo;

import java.util.List;
import internetmotors.veiculo.Veiculo;
import internetmotors.usuario.Usuario;

public interface VeiculoDAO {

	public void salvar(Veiculo veiculo);
	public void atualizar(Veiculo veiculo);
	public void excluir(Veiculo veiculo);
	public Veiculo carregar(Integer codigo);
	public List<Veiculo> listar();
	public List<Veiculo> listarPorUsuario(Usuario usuario);
	public Veiculo buscarUltimoModificado(Integer codUsuario);
	
}
