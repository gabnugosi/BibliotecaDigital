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
@Table(name = "pendencia")
public class Pendencia {
	@Id
	@GeneratedValue
	@Column(name = "id_usuario_pendencia")
	private int id;

	@Column(name = "valor_multa")
	private double valorMulta;

	@Column(name = "pendente_bool")
	private boolean pendente;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idusuario_inadimplente", nullable = false, insertable = false, updatable = false)
	private UsuarioInadimplente usuario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public UsuarioInadimplente getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioInadimplente usuario) {
		this.usuario = usuario;
	}

}
