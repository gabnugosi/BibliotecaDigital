package br.com.intechservices.bibliotecadigital.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue
	@Column(name = "id_usu")
	private int idUser;
	
	@Column(name = "nm_usu")
	private String nomeUsuario;
	
	@Column(name = "email_usu")
	private String emailUsuario;
	
	@Column(name = "cel_usu")
	private String celUsuario;
	
	@Column(name = "registro_identificador")
	private int rg;
	
	@ManyToOne
	@JoinColumn(name = "id_endereco")
	private Endereco idEndereco;
		
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getEmailUsuario() {
		return emailUsuario;
	}
	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}
	public String getCelUsuario() {
		return celUsuario;
	}
	public void setCelUsuario(String celUsuario) {
		this.celUsuario = celUsuario;
	}
	public int getRg() {
		return rg;
	}
	public void setRg(int rg) {
		this.rg = rg;
	}
	public Endereco getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(Endereco idEndereco) {
		this.idEndereco = idEndereco;
	}
	
}
