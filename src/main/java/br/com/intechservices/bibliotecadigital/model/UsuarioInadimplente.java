package br.com.intechservices.bibliotecadigital.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario_inadimplente")
public class UsuarioInadimplente {

	@Id
	@GeneratedValue
	@Column(name = "idusuario_inadimplente")
	private int id;

	@Column(name = "id_usu")
	private int idUser;

	@Column(name = "valor_multa")
	private double valorMulta;

	@Column(name = "devendo_bool")
	private boolean divida;

	@Column(name = "multa_paga_data")
	private Date dataPgtoMulta;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usu", nullable = false, insertable = false, updatable = false)
	private Usuario usuario;

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

	public boolean isDivida() {
		return divida;
	}

	public void setDivida(boolean divida) {
		this.divida = divida;
	}

	public Date getDataPgtoMulta() {
		return dataPgtoMulta;
	}

	public void setDataPgtoMulta(Date dataPgtoMulta) {
		this.dataPgtoMulta = dataPgtoMulta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
