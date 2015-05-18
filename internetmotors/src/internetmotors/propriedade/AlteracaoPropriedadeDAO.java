package internetmotors.propriedade;

import java.util.List;
import internetmotors.usuario.Usuario;

public interface AlteracaoPropriedadeDAO {

	public void salvar(AlteracaoPropriedade alteracaoPropriedade);
	public void atualizar(AlteracaoPropriedade alteracaoPropriedade);
	public void excluir(AlteracaoPropriedade alteracaoPropriedade);
	public List<AlteracaoPropriedade> listar();
	public List<AlteracaoPropriedade> listarPorAlteracao(Usuario usuario);
	
}
