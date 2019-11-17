package br.com.intechservices.bibliotecadigital.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "editora")
public class Editora {

	@Id
	@GeneratedValue
	@Column(name = "id_editora")
	private int id;

	@Column(name = "nm_editora")
	private String nome;

	@OneToMany(mappedBy = "obra")
	private List<Obra> obras;

	public Editora() {
		super();
	}

	public Editora(int id, String nome) {
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
