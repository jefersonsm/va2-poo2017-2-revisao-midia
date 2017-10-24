package br.unincor.exception;

import br.unincor.model.Midia;

public class PrecoZeradoException extends Exception {

	private Midia midia;

	public PrecoZeradoException(Midia midia) {
		super();
		this.midia = midia;
	}

	@Override
	public String getMessage() {
		return "A mídia " + this.midia.getNome() + " está com o preço zerado.";
	}
	
	
}
