package internetmotors.pagamento;

import internetmotors.usuario.Usuario;
import java.util.List;

public interface PagamentoDAO {

	public void salvar(Pagamento pagamento);
	public List<Pagamento> listaPagamentosPorUsuario(Usuario usuario);
	public Pagamento buscarPorAutorizacao(Integer codAutorizacaoExibicao);
	
}
