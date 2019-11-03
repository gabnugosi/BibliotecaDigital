package br.com.intechservices.bibliotecadigital.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item_emprestimo")
public class itemEmprestimo {
	@Id
	@GeneratedValue
	@Column(name = "iditem_emprestimo")	
	private int idItemEmprestimo;
	
	@Column(name = "qtd_item")	
	private int qtdItem;
	
	@Column(name = "dt_emp")	
	private Date dtEmp;
	
	@Column(name = "dt_hora_emprest")	
	private Date dtHoraEmprest;
	
	@Column(name = "dt_hora_devolucao")	
	private	Date dtHoraDevolucao;
	
	
	public int getIdItemEmprestimo() {
		return idItemEmprestimo;
	}
	public void setIdItemEmprestimo(int idItemEmprestimo) {
		this.idItemEmprestimo = idItemEmprestimo;
	}
	public int getQtdItem() {
		return qtdItem;
	}
	public void setQtdItem(int qtdItem) {
		this.qtdItem = qtdItem;
	}
	public Date getDtEmp() {
		return dtEmp;
	}
	public void setDtEmp(Date dtEmp) {
		this.dtEmp = dtEmp;
	}
	public Date getDtHoraEmprest() {
		return dtHoraEmprest;
	}
	public void setDtHoraEmprest(Date dtHoraEmprest) {
		this.dtHoraEmprest = dtHoraEmprest;
	}
	public Date getDtHoraDevolucao() {
		return dtHoraDevolucao;
	}
	public void setDtHoraDevolucao(Date dtHoraDevolucao) {
		this.dtHoraDevolucao = dtHoraDevolucao;
	}

}
