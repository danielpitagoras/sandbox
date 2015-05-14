package internetmotors.servico;

import java.util.List;

public interface ServicoDAO {

	public void salvar(Servico servico);
	public void atualizar(Servico servico);
	public void excluir(Servico servico);
	public List<Servico> listar();
	
}
