package br.com.intechservices.bibliotecadigital.model;



import java.util.Collection;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name = "obra")
/*@SecondaryTable(name = "autor", pkJoinColumns = 
{ @PrimaryKeyJoinColumn(name = "id_autor") })*/
/*@SecondaryTable(name = "editora", pkJoinColumns = 
{ @PrimaryKeyJoinColumn(name = "id_editora") })*/
public class Obra {

	@Id
	@GeneratedValue
	@Column(name = "id_obra")
	private int idObra;

	@ManyToMany
	//@JoinColumn(name = "id_autor", referencedColumnName="id_autor",nullable=false) 
	@JoinTable(name = "autor", 
			joinColumns = { @JoinColumn(name = "obra.id_autor") }, 
			inverseJoinColumns = {@JoinColumn(name = "autor.id_autor") })
	private Set<Autor> autor;
/*
	@ManyToOne
	@JoinTable(name = "nm_editora", joinColumns = { @JoinColumn(name = "id_editora") }, inverseJoinColumns = {
			@JoinColumn(name = "id_editora") })
	private Set<Editora> editora;
*/
	@Column(name = "nm_obra")
	private String nome;

	@Column(name = "descricao_obra")
	private String descricao;

	@Column(name = "edicao_obra")
	private int edicao;

	@Column(name = "tombo")
	private String tombo;

	@Column(name = "ano_publi")
	private String ano;

	@Column(name = "status_obra")
	private String status;

	@Column(name = "categoria")
	private String categoria;

	@Column(name = "qtd_obra")
	private int qtde;

	public Obra() {
	}
/*
	public Obra(int idObra, Set<Autor> autor, Set<Editora> editora, String nome, String descricao, int edicao,
			String tombo, String ano, String status, String categoria, int qtde) {
		super();
		this.idObra = idObra;
		this.autor = autor;
		this.editora = editora;
		this.nome = nome;
		this.descricao = descricao;
		this.edicao = edicao;
		this.tombo = tombo;
		this.ano = ano;
		this.status = status;
		this.categoria = categoria;
		this.qtde = qtde;
	}
*/
	public int getIdObra() {
		return idObra;
	}

	public void setIdObra(int id) {
		this.idObra = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	public String getTombo() {
		return tombo;
	}

	public void setTombo(String tombo) {
		this.tombo = tombo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}
/*
	public Set<Autor> getAutor() {
		return autor;
	}

	public void setAutor(Set<Autor> autor) {
		this.autor = autor;
	}

	public Set<Editora> getEditora() {
		return editora;
	}

	public void setEditora(Set<Editora> editora) {
		this.editora = editora;
	}*/

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

}
