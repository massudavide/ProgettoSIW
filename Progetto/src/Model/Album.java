package Model;

import java.util.List;

public class Album {
	private String titolo;
	private List<Foto> foto;
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
