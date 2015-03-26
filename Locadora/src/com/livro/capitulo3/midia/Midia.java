package com.livro.capitulo3.midia;

import java.io.Serializable;
import javax.persistence.*;
import com.livro.capitulo3.filme.Filme;
import com.livro.capitulo3.locacao.Locacao;

@Entity
@Table(name = "midia")

public class Midia implements Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = -1535698849891925447L;
@Id
@GeneratedValue
@Column(name = "cod_midia")
private Integer midia;

@ManyToOne
@JoinColumn(name = "cod_filme")
private Filme filme;

private String inutilizada;

public Integer getMidia() {
	return midia;
}

public void setMidia(Integer midia) {
	this.midia = midia;
}

public Filme getFilme() {
	return filme;
}

public void setFilme(Filme filme) {
	this.filme = filme;
}

public String getInutilizada() {
	return inutilizada;
}

public void setInutilizada(String inutilizada) {
	this.inutilizada = inutilizada;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((filme == null) ? 0 : filme.hashCode());
	result = prime * result
			+ ((inutilizada == null) ? 0 : inutilizada.hashCode());
	result = prime * result + ((midia == null) ? 0 : midia.hashCode());
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
	Midia other = (Midia) obj;
	if (filme == null) {
		if (other.filme != null)
			return false;
	} else if (!filme.equals(other.filme))
		return false;
	if (inutilizada == null) {
		if (other.inutilizada != null)
			return false;
	} else if (!inutilizada.equals(other.inutilizada))
		return false;
	if (midia == null) {
		if (other.midia != null)
			return false;
	} else if (!midia.equals(other.midia))
		return false;
	return true;
}


	
	
	
}
