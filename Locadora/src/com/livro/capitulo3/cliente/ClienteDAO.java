package com.livro.capitulo3.cliente;

import java.util.List;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import com.livro.capitulo3.locacao.Locacao;

import util.HibernateUtil;

public class ClienteDAO {

	private Session sessao;
	private Transaction transacao;
	
	public void salvar(Cliente cliente) {
		try {
			this.sessao = HibernateUtil.getSessionFactory().getCurrentSession();
			this.transacao = this.sessao.beginTransaction();
			this.sessao.save(cliente);
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
	public void atualizar(Cliente cliente) {
		try {
			this.sessao = HibernateUtil.getSessionFactory().getCurrentSession();
			this.transacao = this.sessao.beginTransaction();
			this.sessao.update(cliente);
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
	public void excluir(Cliente cliente){
		try {
			this.sessao = HibernateUtil.getSessionFactory().getCurrentSession();
			this.transacao = this.sessao.beginTransaction();
			this.sessao.delete(cliente);
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
	public Cliente buscaLocacao(Integer codigo) {
		Cliente cliente = null;
	
		try {	
			this.sessao = HibernateUtil.getSessionFactory().getCurrentSession();
			this.transacao = this.sessao.beginTransaction();
			Criteria filtro = this.sessao.createCriteria(Cliente.class);
			filtro.add(Restrictions.eq("cliente", codigo));
			cliente = (Cliente) filtro.uniqueResult();
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
	return cliente;
	}
	
	public List<Cliente> listar() {
		List<Cliente> clientes = null;
	
		try {
			this.sessao = HibernateUtil.getSessionFactory().getCurrentSession();
			this.transacao = this.sessao.beginTransaction();
			Criteria filtro = this.sessao.createCriteria(Cliente.class);
			clientes = filtro.list();
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
		return clientes;
	}
	
}
