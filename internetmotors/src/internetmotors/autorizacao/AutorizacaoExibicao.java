package internetmotors.autorizacao;

import java.util.*;
import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import internetmotors.usuario.Usuario;
import internetmotors.veiculo.Veiculo;

@Entity
@Table(name = "autorizacaoExibicao")

public class AutorizacaoExibicao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1246607804860651611L;

	@Id
	@GeneratedValue
	@Column(name = "cod_Autorizacao")
	private Integer codigo;
	
	@Column(name = "identificao")
	private String identificacao;
	
	@Column(name = "enderecoLink")
	private String enderecoLink;
	
	@Column(name = "autorizado")
	private Boolean autorizado;
	
	@Column(name = "data")
	private Date data;
	
	@ManyToOne
	@OnDelete(action=OnDeleteAction.CASCADE)
	@JoinColumn(name = "veiculo", nullable = false)
	private Veiculo veiculo;
	
	@ManyToOne
	@OnDelete(action=OnDeleteAction.CASCADE)
	@JoinColumn(name = "usuario", nullable = false)
	private Usuario usuario;

	public String getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getEnderecoLink() {
		return enderecoLink;
	}

	public void setEnderecoLink(String enderecoLink) {
		this.enderecoLink = enderecoLink;
	}

	public Boolean getAutorizado() {
		return autorizado;
	}

	public void setAutorizado(Boolean autorizado) {
		this.autorizado = autorizado;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((autorizado == null) ? 0 : autorizado.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result
				+ ((enderecoLink == null) ? 0 : enderecoLink.hashCode());
		result = prime * result
				+ ((identificacao == null) ? 0 : identificacao.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result + ((veiculo == null) ? 0 : veiculo.hashCode());
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
		AutorizacaoExibicao other = (AutorizacaoExibicao) obj;
		if (autorizado == null) {
			if (other.autorizado != null)
				return false;
		} else if (!autorizado.equals(other.autorizado))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (enderecoLink == null) {
			if (other.enderecoLink != null)
				return false;
		} else if (!enderecoLink.equals(other.enderecoLink))
			return false;
		if (identificacao == null) {
			if (other.identificacao != null)
				return false;
		} else if (!identificacao.equals(other.identificacao))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (veiculo == null) {
			if (other.veiculo != null)
				return false;
		} else if (!veiculo.equals(other.veiculo))
			return false;
		return true;
	}

}
