package com.livro.capitulo3.midia;

import java.util.List;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

public class MidiaDAO {

	private Session sessao;
	private Transaction transacao;
	
	public void salvar(Midia midia) {
		try {
			this.sessao = HibernateUtil.getSessionFactory().getCurrentSession();
			this.transacao = this.sessao.beginTransaction();
			this.sessao.save(midia);
			this.transacao.commit();
		} catch (HibernateException e){
			System.out.println("Não foi possível inserir a categoria. Erro: " + e.getMessage());
		} finally {
			try {
				if(this.sessao.isOpen()) {
					this.sessao.close();
				}
			} catch (Throwable e) {
				System.out.println("Erro ao fechar operação de inserção. Mensagem: " + e.getMessage());
			}
		}
		
	}
	public void atualizar(Midia midia) {
		try {
			this.sessao = HibernateUtil.getSessionFactory().getCurrentSession();
			this.transacao = this.sessao.beginTransaction();
			this.sessao.update(midia);
			this.transacao.commit();
		} catch (HibernateException e) {
			System.out.println("Não foi possível alterar a categoria. Erro: " + e.getMessage());
		} finally{
			try {
				if (this.sessao.isOpen()) {
					this.sessao.close();
				}
			} catch (Throwable e) {
				System.out.println("Erro ao fechar operação de atualização. Mensagem: " + e.getMessage());
			}
		}
	}
	public void excluir(Midia midia){
		try {
			this.sessao = HibernateUtil.getSessionFactory().getCurrentSession();
			this.transacao = this.sessao.beginTransaction();
			this.sessao.delete(midia);
			this.transacao.commit();
		} catch (HibernateException e){
			System.out.println("Não foi possível excluir a categoria. Erro: " + e.getMessage());
		} finally {
			try {
				if (this.sessao.isOpen()) {
					this.sessao.close();
				}
			} catch (Throwable e) {
					System.out.println("Erro ao fechar operação de exclusão. Mensagem: " + e.getMessage());
				}
			}
		}
	public Midia buscaMidia(Integer codigo) {
		Midia midia = null;
	
		try {	
			this.sessao = HibernateUtil.getSessionFactory().getCurrentSession();
			this.transacao = this.sessao.beginTransaction();
			Criteria filtro = this.sessao.createCriteria(Midia.class);
			filtro.add(Restrictions.eq("midia", codigo));
			midia = (Midia) filtro.uniqueResult();
			this.transacao.commit();
		} catch (Throwable e) {
			if (this.transacao.isActive()){
				this.transacao.rollback();
		}
		} finally {
			try {
				if (this.sessao.isOpen()) {
					this.sessao.close();
				}
			} catch (Throwable e) {
				System.out.println("Erro ao fechar operação de busca. Mensagem: " + e.getMessage());
			}
		}
	return midia;
	}
	
	public List<Midia> listar() {
		List<Midia> midias = null;
	
		try {
			this.sessao = HibernateUtil.getSessionFactory().getCurrentSession();
			this.transacao = this.sessao.beginTransaction();
			Criteria filtro = this.sessao.createCriteria(Midia.class);
			midias = filtro.list();
			this.transacao.commit();
		} catch (Throwable e) {
			if(this.transacao.isActive()) {
				this.transacao.rollback();
			}
		} finally {
			try {
				if (this.sessao.isOpen()) {
					this.sessao.close();
				}
			} catch (Throwable e) {
				System.out.println("Erro ao fechar operação de listagem. Mensagem: " + e.getMessage());
			}
		}
		return midias;
	}
	
}
