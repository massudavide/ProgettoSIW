package it.uniroma3.siw.progettoSIW.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Richiesta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	@ManyToMany
	private List<Foto> listaFoto;

	public List<Foto> getListaFoto() {
		return listaFoto;
	}

	public void setListaFoto(List<Foto> listaFoto) {
		this.listaFoto = listaFoto;
	}

	public Long getId() {
		return id;
	}

	
}