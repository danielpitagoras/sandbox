package internetmotors.veiculo;

import java.util.*;
import internetmotors.util.DAOFactory;
import internetmotors.usuario.Usuario;

public class VeiculoRN {
	
	private VeiculoDAO veiculoDAO;
	
	public VeiculoRN() {
		this.veiculoDAO = DAOFactory.criarVeiculoDAO();
	}
	
	public List<Veiculo> listar() {
		return this.veiculoDAO.listar();
	}
	
	public List<Veiculo> listarPorUsuario(Usuario usuario) {
		return this.veiculoDAO.listarPorUsuario(usuario);
	}
	
	public Veiculo carregar(Integer codigo) {
		return this.veiculoDAO.carregar(codigo);
	}
	
	public void salvar(Veiculo veiculo) {
		this.veiculoDAO.salvar(veiculo);
	}
	
	public void excluir(Veiculo veiculo) {
		this.veiculoDAO.excluir(veiculo);
	}
}
