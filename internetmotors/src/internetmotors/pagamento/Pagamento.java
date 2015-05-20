package internetmotors.pagamento;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import internetmotors.autorizacao.AutorizacaoExibicao;
import internetmotors.usuario.Usuario;

@Entity
@Table(name = "pagamento")

public class Pagamento implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 9133874296347992083L;

	@Id
	@GeneratedValue
	@Column(name = "cod_Pagamento")
	private Integer codigo;
	
	@Column(name = "bandeiraCartao")
	private String bandeiraCartao;
	
	@Column(name = "numeroCartao")
	private String numeroCartao;
	
	@Column(name = "codSegCartao")
	private Integer codSegCartao;
	
	@Column(name = "nomeTitularCartao")
	private String nomeTitularCartao;
	
	@Column(name = "dataValidadeCartao")
	private String dataValidadeCartao;
	
	@Column(name = "modalidadePagamento")
	private String modalidadePagamento;
	
	@Column(name = "statusPagamento")
	private String statusPagamento;
	
	@ManyToOne
	@OnDelete(action=OnDeleteAction.CASCADE)
	@JoinColumn(name = "usuario", nullable = false)
	private Usuario usuario;
	
	@ManyToOne
	@OnDelete(action=OnDeleteAction.CASCADE)
	@JoinColumn(name = "autorizacaoExibicao", nullable = false)
	private AutorizacaoExibicao autorizacaoExibicao;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getBandeiraCartao() {
		return bandeiraCartao;
	}

	public void setBandeiraCartao(String bandeiraCartao) {
		this.bandeiraCartao = bandeiraCartao;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public Integer getCodSegCartao() {
		return codSegCartao;
	}

	public void setCodSegCartao(Integer codSegCartao) {
		this.codSegCartao = codSegCartao;
	}

	public String getNomeTitularCartao() {
		return nomeTitularCartao;
	}

	public void setNomeTitularCartao(String nomeTitularCartao) {
		this.nomeTitularCartao = nomeTitularCartao;
	}

	public String getDataValidadeCartao() {
		return dataValidadeCartao;
	}

	public void setDataValidadeCartao(String dataValidadeCartao) {
		this.dataValidadeCartao = dataValidadeCartao;
	}

	public String getModalidadePagamento() {
		return modalidadePagamento;
	}

	public void setModalidadePagamento(String modalidadePagamento) {
		this.modalidadePagamento = modalidadePagamento;
	}

	public String getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(String statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public AutorizacaoExibicao getAutorizacaoExibicao() {
		return autorizacaoExibicao;
	}

	public void setAutorizacaoExibicao(AutorizacaoExibicao autorizacaoExibicao) {
		this.autorizacaoExibicao = autorizacaoExibicao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((autorizacaoExibicao == null) ? 0 : autorizacaoExibicao
						.hashCode());
		result = prime * result
				+ ((bandeiraCartao == null) ? 0 : bandeiraCartao.hashCode());
		result = prime * result
				+ ((codSegCartao == null) ? 0 : codSegCartao.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime
				* result
				+ ((dataValidadeCartao == null) ? 0 : dataValidadeCartao
						.hashCode());
		result = prime
				* result
				+ ((modalidadePagamento == null) ? 0 : modalidadePagamento
						.hashCode());
		result = prime
				* result
				+ ((nomeTitularCartao == null) ? 0 : nomeTitularCartao
						.hashCode());
		result = prime * result
				+ ((numeroCartao == null) ? 0 : numeroCartao.hashCode());
		result = prime * result
				+ ((statusPagamento == null) ? 0 : statusPagamento.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		if (autorizacaoExibicao == null) {
			if (other.autorizacaoExibicao != null)
				return false;
		} else if (!autorizacaoExibicao.equals(other.autorizacaoExibicao))
			return false;
		if (bandeiraCartao == null) {
			if (other.bandeiraCartao != null)
				return false;
		} else if (!bandeiraCartao.equals(other.bandeiraCartao))
			return false;
		if (codSegCartao == null) {
			if (other.codSegCartao != null)
				return false;
		} else if (!codSegCartao.equals(other.codSegCartao))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (dataValidadeCartao == null) {
			if (other.dataValidadeCartao != null)
				return false;
		} else if (!dataValidadeCartao.equals(other.dataValidadeCartao))
			return false;
		if (modalidadePagamento == null) {
			if (other.modalidadePagamento != null)
				return false;
		} else if (!modalidadePagamento.equals(other.modalidadePagamento))
			return false;
		if (nomeTitularCartao == null) {
			if (other.nomeTitularCartao != null)
				return false;
		} else if (!nomeTitularCartao.equals(other.nomeTitularCartao))
			return false;
		if (numeroCartao == null) {
			if (other.numeroCartao != null)
				return false;
		} else if (!numeroCartao.equals(other.numeroCartao))
			return false;
		if (statusPagamento == null) {
			if (other.statusPagamento != null)
				return false;
		} else if (!statusPagamento.equals(other.statusPagamento))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	
	
}
