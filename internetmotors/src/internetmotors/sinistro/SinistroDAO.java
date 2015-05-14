package internetmotors.sinistro;

import java.util.List;
import internetmotors.veiculo.Veiculo;

public interface SinistroDAO {
	
	public void salvar(Sinistro sinistro);
	public void atualizar(Sinistro sinistro);
	public void excluir(Sinistro sinistro);
	public List<Sinistro> listar();

}
