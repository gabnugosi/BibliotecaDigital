package br.com.intechservices.bibliotecadigital.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "autor")
public class Autor {
	
	
	
	public Autor() {}

	@Id
	@GeneratedValue
	@Column(name = "id_autor")
	private int id;
		
	@Column(name = "nm_autor")
	private String nome;
	
	@ManyToMany(mappedBy="autor")  
	private Set<Obra> obra;
	
	public Autor(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
