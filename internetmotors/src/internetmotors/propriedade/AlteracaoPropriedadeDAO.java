package internetmotors.propriedade;

import java.util.List;

public interface AlteracaoPropriedadeDAO {

	public void salvar(AlteracaoPropriedade alteracaoPropriedade);
	public void atualizar(AlteracaoPropriedade alteracaoPropriedade);
	public void excluir(AlteracaoPropriedade alteracaoPropriedade);
	public List<AlteracaoPropriedade> listar();
	
}
