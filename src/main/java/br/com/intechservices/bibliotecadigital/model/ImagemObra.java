package br.com.intechservices.bibliotecadigital.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "imagem_obra")
public class ImagemObra {
	@Id
	@GeneratedValue
	@Column(name = "id_img_obra")
	private int id;

	@Column(name = "urlimg")
	private String urlimg;

	@Column(name = "id_obra")
	private int idObra;

	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "id_obra", nullable=false, insertable=false, updatable=false)
	private Usuario imagemObra;
	
	public ImagemObra() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrlimg() {
		return urlimg;
	}

	public void setUrlimg(String urlimg) {
		this.urlimg = urlimg;
	}

	public int getIdObra() {
		return idObra;
	}

	public void setIdObra(int idObra) {
		this.idObra = idObra;
	}

}
