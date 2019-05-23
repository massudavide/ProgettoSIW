package Model;

import java.util.List;

public class Fotografo {
String nome;
String cognome;
private List<Album> album;


//Getters & Setters
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getCognome() {
	return cognome;
}
public void setCognome(String cognome) {
	this.cognome = cognome;
}
public List<Album> getAlbum() {
	return album;
}
public void setAlbum(List<Album> album) {
	this.album = album;
}


}
