package br.com.intechservices.bibliotecadigital.model;

import java.util.Date;
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
@Table(name = "reserva")
public class Reserva {
		
		@Id
		@GeneratedValue
		@Column(name = "id_reserva")
		private int id;
		
		@Column(name = "dt_hora_reserva")
		private Date dtHoraReserva;
		
		@Column(name = "prazo_reserva")
		private int prazoReserva;
		
		@Column(name = "situacao_reserva")
		private String situacaoReserva;		
		
		/*@Column(name = "id_usu")
		private int idUser;*/

		@ManyToMany
		@JoinTable(name = "reserva_obra", joinColumns = { @JoinColumn(name = "id_reserva") }, inverseJoinColumns = {
				@JoinColumn(name = "id_obra") })
		private List<Obra> obras;
		
		@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
		@JoinColumn(name = "id_usu", nullable=false, insertable=false, updatable=false)
		private Usuario reserva;
		
		public Reserva() {}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public Date getDtHoraReserva() {
			return dtHoraReserva;
		}
		public void setDtHoraReserva(Date dtHoraReserva) {
			this.dtHoraReserva = dtHoraReserva;
		}
		public int getPrazoReserva() {
			return prazoReserva;
		}
		public void setPrazoReserva(int prazoReserva) {
			this.prazoReserva = prazoReserva;
		}
		public String getSituacaoReserva() {
			return situacaoReserva;
		}
		public void setSituacaoReserva(String situacaoReserva) {
			this.situacaoReserva = situacaoReserva;
		}
		/*public int getIdUser() {
			return idUser;
		}
		public void setIdUser(int idUser) {
			this.idUser = idUser;
		}*/
		
		
}
