package internetmotors.veiculo;

import java.util.*;
import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import internetmotors.usuario.Usuario;

@Entity
@Table(name = "veiculo")

public class Veiculo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6227973180852764373L;

	@Id
	@GeneratedValue
	@Column(name = "cod_Veiculo")
	private Integer codigo;
	
	@Column(name = "imagem1", nullable = false, columnDefinition="mediumblob")
	private byte[] imagem1;
	
	@Column(name = "imagem2", columnDefinition="mediumblob")
	private byte[] imagem2;
	
	@Column(name = "imagem3", columnDefinition="mediumblob")
	private byte[] imagem3;
	
	@Column(name = "imagem4", columnDefinition="mediumblob")
	private byte[] imagem4;
	
	@Column(name = "imagem5", columnDefinition="mediumblob")
	private byte[] imagem5;
	
	@Column(name = "placa", nullable = false)
	private String placa;
	
	@Column(name = "categoria", nullable = false)
	private String categoria;
	
	@Column(name = "marca", nullable = false)
	private String marca;
	
	@Column(name = "modelo", nullable = false)
	private String modelo;
	
	@Column(name = "cor", nullable = false)
	private String cor;
	
	@Column(name = "chassi", nullable = false)
	private String chassi;
	
	@Column(name = "quilometragem", nullable = false)
	private Integer quilometragem;
	
	@Column(name = "data_fabricacao", nullable = false)
	private Date dataFabricacao;
	
	@Column(name = "data_modelo", nullable = false)
	private Date dataModelo;
	
	@Column(name = "data_criacao", nullable = false)
	private Date dataCriacao;
	
	@Column(name = "data_Modificacao", nullable = false)
	private Date dataModificacao;
	
	@ManyToOne
	@OnDelete(action=OnDeleteAction.CASCADE)
	@JoinColumn(name = "usuario", nullable = false)
	private Usuario usuario;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public byte[] getImagem1() {
		return imagem1;
	}

	public void setImagem1(byte[] imagem1) {
		this.imagem1 = imagem1;
	}

	public byte[] getImagem2() {
		return imagem2;
	}

	public void setImagem2(byte[] imagem2) {
		this.imagem2 = imagem2;
	}

	public byte[] getImagem3() {
		return imagem3;
	}

	public void setImagem3(byte[] imagem3) {
		this.imagem3 = imagem3;
	}

	public byte[] getImagem4() {
		return imagem4;
	}

	public void setImagem4(byte[] imagem4) {
		this.imagem4 = imagem4;
	}

	public byte[] getImagem5() {
		return imagem5;
	}

	public void setImagem5(byte[] imagem5) {
		this.imagem5 = imagem5;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public Integer getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(Integer quilometragem) {
		this.quilometragem = quilometragem;
	}

	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public Date getDataModelo() {
		return dataModelo;
	}

	public void setDataModelo(Date dataModelo) {
		this.dataModelo = dataModelo;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataModificacao() {
		return dataModificacao;
	}

	public void setDataModificacao(Date dataModificacao) {
		this.dataModificacao = dataModificacao;
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
				+ ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((chassi == null) ? 0 : chassi.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((cor == null) ? 0 : cor.hashCode());
		result = prime * result
				+ ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result
				+ ((dataFabricacao == null) ? 0 : dataFabricacao.hashCode());
		result = prime * result
				+ ((dataModelo == null) ? 0 : dataModelo.hashCode());
		result = prime * result
				+ ((dataModificacao == null) ? 0 : dataModificacao.hashCode());
		result = prime * result + Arrays.hashCode(imagem1);
		result = prime * result + Arrays.hashCode(imagem2);
		result = prime * result + Arrays.hashCode(imagem3);
		result = prime * result + Arrays.hashCode(imagem4);
		result = prime * result + Arrays.hashCode(imagem5);
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		result = prime * result
				+ ((quilometragem == null) ? 0 : quilometragem.hashCode());
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
		Veiculo other = (Veiculo) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (chassi == null) {
			if (other.chassi != null)
				return false;
		} else if (!chassi.equals(other.chassi))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (cor == null) {
			if (other.cor != null)
				return false;
		} else if (!cor.equals(other.cor))
			return false;
		if (dataCriacao == null) {
			if (other.dataCriacao != null)
				return false;
		} else if (!dataCriacao.equals(other.dataCriacao))
			return false;
		if (dataFabricacao == null) {
			if (other.dataFabricacao != null)
				return false;
		} else if (!dataFabricacao.equals(other.dataFabricacao))
			return false;
		if (dataModelo == null) {
			if (other.dataModelo != null)
				return false;
		} else if (!dataModelo.equals(other.dataModelo))
			return false;
		if (dataModificacao == null) {
			if (other.dataModificacao != null)
				return false;
		} else if (!dataModificacao.equals(other.dataModificacao))
			return false;
		if (!Arrays.equals(imagem1, other.imagem1))
			return false;
		if (!Arrays.equals(imagem2, other.imagem2))
			return false;
		if (!Arrays.equals(imagem3, other.imagem3))
			return false;
		if (!Arrays.equals(imagem4, other.imagem4))
			return false;
		if (!Arrays.equals(imagem5, other.imagem5))
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		if (quilometragem == null) {
			if (other.quilometragem != null)
				return false;
		} else if (!quilometragem.equals(other.quilometragem))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	
	
}
