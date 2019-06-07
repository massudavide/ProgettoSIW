package it.uniroma3.siw.progettoSIW.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Album {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String titolo;
	
	@OneToMany (mappedBy="album")
	private List<Foto> foto;
	
	@ManyToOne
	private Fotografo fotografo;
	
	
	
	// Getters & Setters
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public List<Foto> getFoto() {
		return foto;
	}
	public void setFoto(List<Foto> foto) {
		this.foto = foto;
	}
	public Fotografo getFotografo() {
		return fotografo;
	}
	public void setFotografo(Fotografo fotografo) {
		this.fotografo = fotografo;
	}
	
	
	

	

}
