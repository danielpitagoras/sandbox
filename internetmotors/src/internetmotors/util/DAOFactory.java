package internetmotors.util;

import internetmotors.usuario.*;
import internetmotors.veiculo.*;
import internetmotors.endereco.*;


public class DAOFactory {
	
	public static UsuarioDAO criarUsuarioDAO() {
		
		UsuarioDAOHibernate usuarioDAO = new UsuarioDAOHibernate();
		usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDAO;
		
	}
	
	public static EnderecoDAO criarEnderecoDAO() {
		
		EnderecoDAOHibernate enderecoDAO = new EnderecoDAOHibernate();
		enderecoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return enderecoDAO;
		
	}
	
	public static VeiculoDAO criarVeiculoDAO() {
		
		VeiculoDAOHibernate veiculoDAO = new VeiculoDAOHibernate();
		veiculoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return veiculoDAO;
		
	}
	
}
