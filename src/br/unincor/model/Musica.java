package br.unincor.model;

public class Musica extends Midia {

	private String artista;
	private Boolean dominioPublico;
	
	public Musica(String nome, Double precoBase, String artista, Boolean dominioPublico) {
		super(nome, precoBase);
		this.artista = artista;
		this.dominioPublico = dominioPublico;
	}
	
	public String getArtista() {
		return artista;
	}
	public void setArtista(String artista) {
		this.artista = artista;
	}
	public Boolean getDominioPublico() {
		return dominioPublico;
	}
	public void setDominioPublico(Boolean dominioPublico) {
		this.dominioPublico = dominioPublico;
	}
	
	public String verDados() {
		return super.verDados() + "\nArtista: " + this.artista +
				"\nDominio público: " + this.dominioPublico;
	}
}




















