package internetmotors.util;

import internetmotors.ocorrencia.OcorrenciaDAOHibernate;
import internetmotors.usuario.*;
import internetmotors.veiculo.*;
import internetmotors.endereco.*;
import internetmotors.ocorrencia.*;
import internetmotors.servico.*;
import internetmotors.sinistro.*;
import internetmotors.propriedade.*;


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
	
	public static OcorrenciaDAO criarOcorrenciaDAO() {
		
		OcorrenciaDAOHibernate ocorrenciaDAO = new OcorrenciaDAOHibernate();
		ocorrenciaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return ocorrenciaDAO;
		
	}
	
	public static AlteracaoPropriedadeDAO criarAlteracaoPropriedadeDAO() {
		
		AlteracaoPropriedadeDAOHibernate alteracaoPropriedadeDAO = new AlteracaoPropriedadeDAOHibernate();
		alteracaoPropriedadeDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return alteracaoPropriedadeDAO;
	}
	
	public static ServicoDAO criarServicoDAO() {
		
		ServicoDAOHibernate servicoDAO = new ServicoDAOHibernate();
		servicoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return servicoDAO;
		
	}
	
	public static SinistroDAO criarSinistroDAO() {
		
		SinistroDAOHibernate sinistroDAO = new SinistroDAOHibernate();
		sinistroDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return sinistroDAO;
		
	}
	
}
