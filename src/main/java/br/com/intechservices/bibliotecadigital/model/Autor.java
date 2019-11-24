package br.com.intechservices.bibliotecadigital.model;

import java.util.List;


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
	
	@ManyToMany(mappedBy = "autores")
	private List<Obra> obras;
	
	@Column(name = 	"FIRSTNAME")
	private String firstname;
	
	@Column(name = 	"LASTNAME")
	private String lastname;
	
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

	public List<Obra> getObras() {
		return obras;
	}

	public void setObras(List<Obra> obras) {
		this.obras = obras;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}
