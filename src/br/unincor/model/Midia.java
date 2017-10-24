package br.unincor.model;

import java.text.DecimalFormat;

public class Midia {
	
	private String nome;
	private Double precoBase;
	private Double precoFinal;
	
	public Midia(String nome, Double precoBase) {
		super();
		this.nome = nome;
		
		if(precoBase >= 0)
			this.precoBase = precoBase;
		
		this.precoFinal = 0.0;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPrecoBase() {
		return precoBase;
	}
	public void setPrecoBase(Double precoBase) {
		if(precoBase >= 0)
			this.precoBase = precoBase;
	}
	public Double getPrecoFinal() {
		return precoFinal;
	}
	public void setPrecoFinal(Double precoFinal) {
		if(precoFinal >= 0)
			this.precoFinal = precoFinal;
	}

	public String verDados() {
		DecimalFormat df = new DecimalFormat("0.00");
		
		return "Nome: " + this.nome +
				"\nPreço base: R$" + df.format(this.precoBase) + 
				"\nPreço final: R$" + df.format(this.precoFinal);
	}
}















