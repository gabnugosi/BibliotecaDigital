package br.com.intechservices.bibliotecadigital.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
		
		@Column(name = "id_usu")
		private int idUser;
		
		@Column(name = "id_obra")
		private int idObra;
		
		public Reserva() {}

		public Reserva(int id, Date dtHoraReserva, int prazoReserva, String situacaoReserva, int idObra, int idUser) {
			super();
			this.id = id;
			this.dtHoraReserva = dtHoraReserva;
			this.prazoReserva = prazoReserva;
			this.situacaoReserva = situacaoReserva;
			this.idObra = idObra;
			this.idUser = idUser;
		}
		
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
		public int getIdObra() {
			return idObra;
		}
		public void setIdObra(int idObra) {
			this.idObra = idObra;
		}
		public int getIdUser() {
			return idUser;
		}
		public void setIdUser(int idUser) {
			this.idUser = idUser;
		}
		
		
}
