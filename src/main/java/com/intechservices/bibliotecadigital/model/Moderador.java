package com.intechservices.bibliotecadigital.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "moderador")
public class Moderador {
	@Id
	@GeneratedValue
	@Column(name = "idmoderador")
	private int id;
	@Column(name = "id_usu")
	private int idUser;
}
