package internetmotors.pagamento;

import java.util.*;

import internetmotors.util.DAOFactory;
import internetmotors.usuario.Usuario;
import internetmotors.autorizacao.*;

public class PagamentoRN {
	
	private PagamentoDAO pagamentoDAO;
	
	public PagamentoRN() {
		this.pagamentoDAO = DAOFactory.criarPagamentoDAO();
	}
	
	public void salvar(Pagamento pagamento) {
		
		AutorizacaoExibicaoRN autorizacaoExibicaoRN = new AutorizacaoExibicaoRN();
		AutorizacaoExibicao autorizacaoExibicaoPAtualizar = new AutorizacaoExibicao();
		
		autorizacaoExibicaoPAtualizar = pagamento.getAutorizacaoExibicao();
		autorizacaoExibicaoPAtualizar.setAutorizado(true);
		autorizacaoExibicaoPAtualizar.setEnderecoLink("/InternetMotors/publico/historico.jsf?codAutorizacao=" + autorizacaoExibicaoPAtualizar.getCodigo() + "?codSeguranca=" + this.geraValor());
		autorizacaoExibicaoRN.salvar(autorizacaoExibicaoPAtualizar);
		
		this.pagamentoDAO.salvar(pagamento);
	}
	
	private String geraValor(){
		String uuid = UUID.randomUUID().toString();
		return uuid;
	}

	public List<Pagamento> listaPagamentosPorUsuario(Usuario usuario){
		return this.pagamentoDAO.listaPagamentosPorUsuario(usuario);
	}
	
	public Pagamento buscarPorAutorizacao(Integer codAutorizacaoExibicao) {
		return this.buscarPorAutorizacao(codAutorizacaoExibicao);
	}
	
}
