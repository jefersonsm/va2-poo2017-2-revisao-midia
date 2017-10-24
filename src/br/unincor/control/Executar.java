package br.unincor.control;

import java.util.ArrayList;
import java.util.List;

import br.unincor.exception.PrecoZeradoException;
import br.unincor.model.Midia;
import br.unincor.model.Musica;
import br.unincor.model.Video;
import br.unincor.view.Usuario;

public class Executar {

	public static void main(String[] args) {
		Usuario view = new Usuario();
		CalculaPrecos calc = new CalculaPrecos();
		List<Midia> listMidia = new ArrayList<Midia>();
	
		Integer op = 0;
		while(op != -1 && op != 2) {
			op = view.exibeMenu();
			
			try {
				if(op == 0) {
					//Musica
					Musica musica = new Musica("Nome", 100.0, "Artista", true);
					calc.calculaPrecoFinal(musica);
					listMidia.add(musica);
				} else if(op == 1) {
					//Video
					Video video = new Video("Nome", 100.0, "Autor", true);
					calc.calculaPrecoFinal(video);
					listMidia.add(video);
				}
			} catch (PrecoZeradoException pze) {
				view.exibeMsg(pze.getMessage());
			}
		}
		
		Integer opPagto = view.exibePagto();
		Double valorFinal = 0.0;
		if(opPagto == 1) {
			//Cartão
			valorFinal = calc.pagtoCartao(listMidia);
		} else {
			//Boleto
			valorFinal = calc.pagtoBoleto(listMidia);
		}
		
		view.exibeMsg("Resumo do pedido");
		for (Midia midia : listMidia) {
			view.exibeMsg(midia.verDados());
		}
		view.exibeMsg("Valor final: " + valorFinal);
	}
}
















