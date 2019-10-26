package com.intechservices.bibliotecadigital.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pendencia")
public class Pendencia {
	@Id
	@GeneratedValue
	@Column(name = "id_usuario_pendencia")
	private int id;
	
	@Column(name = "id_usu")
	private int idUser;
	@Column(name = "valor_multa")
	private double valorMulta;
	@Column(name = "pendente_bool")
	private boolean pendente;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public double getValorMulta() {
		return valorMulta;
	}
	public void setValorMulta(double valorMulta) {
		this.valorMulta = valorMulta;
	}
	public boolean isPendente() {
		return pendente;
	}
	public void setPendente(boolean pendente) {
		this.pendente = pendente;
	}
	
	
}
