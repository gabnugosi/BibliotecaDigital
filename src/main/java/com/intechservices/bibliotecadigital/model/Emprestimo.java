package com.intechservices.bibliotecadigital.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emprestimo")
public class Emprestimo {
	@Id
	@GeneratedValue
	@Column(name = "id_emp")	
	private int idEmp;
	
	@Column(name = "id_usu")
	private int idUser;
	
	@Column(name = "iditem_emprestimo")
	private int idItemEmprestimo;
	
	@Column(name = "dt_reserva")
	private Date dtReserva;
	
	@Column(name = "dt_hora_devolucao")
	private Date dtHoraDevolucao;
	
	@Column(name = "dt_hora_emp")
	private Date dtHoraEmp;
	
	@Column(name = "dt_emprestimo_concluido")
	private Date dtEmprestimoConcluido;
	
	
	public int getIdEmp() {
		return idEmp;
	}
	public void setIdEmp(int idEmp) {
		this.idEmp = idEmp;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getIdItemEmprestimo() {
		return idItemEmprestimo;
	}
	public void setIdItemEmprestimo(int idItemEmprestimo) {
		this.idItemEmprestimo = idItemEmprestimo;
	}
	public Date getDtReserva() {
		return dtReserva;
	}
	public void setDtReserva(Date dtReserva) {
		this.dtReserva = dtReserva;
	}
	public Date getDtHoraDevolucao() {
		return dtHoraDevolucao;
	}
	public void setDtHoraDevolucao(Date dtHoraDevolucao) {
		this.dtHoraDevolucao = dtHoraDevolucao;
	}
	public Date getDtHoraEmp() {
		return dtHoraEmp;
	}
	public void setDtHoraEmp(Date dtHoraEmp) {
		this.dtHoraEmp = dtHoraEmp;
	}
	public Date getDtEmprestimoConcluido() {
		return dtEmprestimoConcluido;
	}
	public void setDtEmprestimoConcluido(Date dtEmprestimoConcluido) {
		this.dtEmprestimoConcluido = dtEmprestimoConcluido;
	}
		
}
