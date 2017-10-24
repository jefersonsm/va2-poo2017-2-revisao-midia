package br.unincor.control;

import java.util.List;

import javax.swing.text.html.MinimalHTMLWriter;

import br.unincor.exception.PrecoZeradoException;
import br.unincor.model.Midia;
import br.unincor.model.Musica;
import br.unincor.model.Video;

public class CalculaPrecos {
	
	public void calculaPrecoFinal(Midia midia) throws PrecoZeradoException {
		if(midia.getPrecoBase() != null && midia.getPrecoBase() != 0) {
			//Preço da mídia está ok!
			
			if(midia instanceof Musica) {
				Musica musica = (Musica)midia;
				
				if(musica.getDominioPublico()) {
					musica.setPrecoFinal(musica.getPrecoBase()*0.7);
				} else {
					musica.setPrecoFinal(musica.getPrecoBase()*1.1);
				}
				
			} else if(midia instanceof Video) {
				Video video = (Video)midia;
				
				if(video.getMidiaDigital()) {
					video.setPrecoFinal(video.getPrecoBase()*0.9);
				} else {
					video.setPrecoFinal(video.getPrecoBase()*1.2);
				}
			}
			
		} else {
			//Mídia está com o preço zerado!
			throw new PrecoZeradoException(midia);
		}
	}

	public Double pagtoBoleto(List<Midia> listMidia) {
		Double somaPreco = 0.0;
		
		for (Midia midia : listMidia) {
			somaPreco += midia.getPrecoFinal();
		}
		
		return somaPreco*0.9;
	}
	
	public Double pagtoCartao(List<Midia> listMidia) {
		Double somaPreco = 0.0;
		
		for (Midia midia : listMidia) {
			somaPreco += midia.getPrecoFinal();
		}
		
		return somaPreco*1.15;
	}
}














