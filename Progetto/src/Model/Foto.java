package Model;

import java.time.LocalDateTime;

public class Foto {
	private String titolo;
	private Album album;
	private LocalDateTime dataCreazione;
	/*Prova url*/
	private String url;
	
	
public Foto () {
	this.dataCreazione= LocalDateTime.now();
}


// Getters & Setters
public String getTitolo() {
	return titolo;
}


public void setTitolo(String titolo) {
	this.titolo = titolo;
}


public Album getAlbum() {
	return album;
}


public void setAlbum(Album album) {
	this.album = album;
}


public LocalDateTime getDataCreazione() {
	return dataCreazione;
}


public void setDataCreazione(LocalDateTime dataCreazione) {
	this.dataCreazione = dataCreazione;
}



/********************PROVA************************/
public String getUrl() {
	return url;
}


public void setUrl(String url) {
	this.url = url;
}


}
