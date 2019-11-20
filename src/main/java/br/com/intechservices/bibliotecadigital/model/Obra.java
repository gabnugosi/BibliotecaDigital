package br.com.intechservices.bibliotecadigital.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "obra")
public class Obra {

	@Id
	@GeneratedValue
	@Column(name = "id_obra")
	private int idObra;

	@Column(name = "id_editora")
	private int idEditora;

	@ManyToMany
	@JoinTable(name = "obra_autor", joinColumns = { @JoinColumn(name = "id_obra") }, inverseJoinColumns = {
			@JoinColumn(name = "id_autor") })
	private List<Autor> autores;

	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "id_editora", nullable=false, insertable=false, updatable=false)
	private Editora obra;
	
	@ManyToMany(mappedBy = "obras")
	private List<Reserva> reservas;

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

	public Obra() {
	}

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

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public int getIdEditora() {
		return idEditora;
	}

	public void setIdEditora(int idEditora) {
		this.idEditora = idEditora;
	}

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
}
