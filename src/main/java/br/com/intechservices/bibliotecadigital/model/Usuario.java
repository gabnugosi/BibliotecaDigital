package br.com.intechservices.bibliotecadigital.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue
	@Column(name = "id_usu")
	private int idUser;

	@Column(name = "nm_usu")
	private String nome;

	@Column(name = "email_usu")
	private String emailUsuario;

	@Column(name = "cel_usu")
	private String celUsuario;

	@Column(name = "registro_identificador")
	private long rg;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_endereco", nullable = false, insertable = false, updatable = false)
	private Endereco idEndereco;

	@OneToMany(mappedBy = "reserva")
	private List<Reserva> reservas;

	@OneToMany(mappedBy = "emprestimo")
	private List<Emprestimo> emprestimos;

	@OneToMany(mappedBy = "itemEmprestimoUsuario")
	private List<ItemEmprestimo> itemEmprestimo;

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nomeUsuario) {
		this.nome = nomeUsuario;
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

	public long getRg() {
		return rg;
	}

	public void setRg(long rg) {
		this.rg = rg;
	}

	public Endereco getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Endereco idEndereco) {
		this.idEndereco = idEndereco;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}

	public List<ItemEmprestimo> getItemEmprestimo() {
		return itemEmprestimo;
	}

	public void setItemEmprestimo(List<ItemEmprestimo> itemEmprestimo) {
		this.itemEmprestimo = itemEmprestimo;
	}

}
