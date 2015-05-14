package internetmotors.propriedade;

import internetmotors.usuario.Usuario;
import internetmotors.ocorrencia.Ocorrencia;

import javax.persistence.*;

import java.io.Serializable;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "alteracaoPropriedade")

public class AlteracaoPropriedade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4292963076593804937L;

	@Id
	@GeneratedValue
	@Column(name = "cod_altPropriedade")
	private Integer codigo;
	
	@Column(name = "emailNovoProprietario")
	private String emailNovoProprietario;
	
	@Column(name = "nomeNovoProprietario")
	private String nomeNovoProprietario;
	
	@Column(name = "status")
	private String status;
	
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

	public String getEmailNovoProprietario() {
		return emailNovoProprietario;
	}

	public void setEmailNovoProprietario(String emailNovoProprietario) {
		this.emailNovoProprietario = emailNovoProprietario;
	}

	public String getNomeNovoProprietario() {
		return nomeNovoProprietario;
	}

	public void setNomeNovoProprietario(String nomeNovoProprietario) {
		this.nomeNovoProprietario = nomeNovoProprietario;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime
				* result
				+ ((emailNovoProprietario == null) ? 0 : emailNovoProprietario
						.hashCode());
		result = prime
				* result
				+ ((nomeNovoProprietario == null) ? 0 : nomeNovoProprietario
						.hashCode());
		result = prime * result
				+ ((ocorrencia == null) ? 0 : ocorrencia.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		AlteracaoPropriedade other = (AlteracaoPropriedade) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (emailNovoProprietario == null) {
			if (other.emailNovoProprietario != null)
				return false;
		} else if (!emailNovoProprietario.equals(other.emailNovoProprietario))
			return false;
		if (nomeNovoProprietario == null) {
			if (other.nomeNovoProprietario != null)
				return false;
		} else if (!nomeNovoProprietario.equals(other.nomeNovoProprietario))
			return false;
		if (ocorrencia == null) {
			if (other.ocorrencia != null)
				return false;
		} else if (!ocorrencia.equals(other.ocorrencia))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	
	
	
}
