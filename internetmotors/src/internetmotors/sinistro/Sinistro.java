package internetmotors.sinistro;

import internetmotors.usuario.Usuario;
import internetmotors.ocorrencia.Ocorrencia;

import javax.persistence.*;

import java.io.Serializable;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "sinistro")

public class Sinistro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1038986359405204507L;

	@Id
	@GeneratedValue
	@Column(name = "cod_sinistro")
	private Integer codigo;
	
	@Column(name = "identificao")
	private String identificacao;
	
	@Column(name = "tipo")
	private String tipo;
	
	@Column(name = "exibicaoAtiva")
	private boolean exibicaoAtiva;
	
	@Column(name = "danos")
	private String danos;
	
	@Column(name = "observacao")
	private String observacao;
	
	@ManyToOne
	@OnDelete(action=OnDeleteAction.CASCADE)
	@JoinColumn(name = "usuario", nullable = false)
	private Usuario usuario;
	
	@ManyToOne
	@OnDelete(action=OnDeleteAction.CASCADE)
	@JoinColumn(name = "ocorrencia", nullable = false)
	private Ocorrencia ocorrencia;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isExibicaoAtiva() {
		return exibicaoAtiva;
	}

	public void setExibicaoAtiva(boolean exibicaoAtiva) {
		this.exibicaoAtiva = exibicaoAtiva;
	}

	public String getDanos() {
		return danos;
	}

	public void setDanos(String danos) {
		this.danos = danos;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Ocorrencia getOcorrencia() {
		return ocorrencia;
	}

	public void setOcorrencia(Ocorrencia ocorrencia) {
		this.ocorrencia = ocorrencia;
	}

	public String getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((danos == null) ? 0 : danos.hashCode());
		result = prime * result + (exibicaoAtiva ? 1231 : 1237);
		result = prime * result
				+ ((identificacao == null) ? 0 : identificacao.hashCode());
		result = prime * result
				+ ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result
				+ ((ocorrencia == null) ? 0 : ocorrencia.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Sinistro other = (Sinistro) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (danos == null) {
			if (other.danos != null)
				return false;
		} else if (!danos.equals(other.danos))
			return false;
		if (exibicaoAtiva != other.exibicaoAtiva)
			return false;
		if (identificacao == null) {
			if (other.identificacao != null)
				return false;
		} else if (!identificacao.equals(other.identificacao))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (ocorrencia == null) {
			if (other.ocorrencia != null)
				return false;
		} else if (!ocorrencia.equals(other.ocorrencia))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	
	
	
}
