package br.com.intechservices.bibliotecadigital.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario_senha")
public class UsuarioSenha {

	@Id
	@GeneratedValue
	@Column(name = "idsuario_senha")
	private int id;

	@Column(name = "senha")
	private String senha;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usu", nullable = false, insertable = false, updatable = false)
	private Usuario usuario;
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
