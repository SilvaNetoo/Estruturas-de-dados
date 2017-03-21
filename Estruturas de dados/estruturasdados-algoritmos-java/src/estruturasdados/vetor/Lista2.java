package estruturasdados.vetor;

import estruturasdados.base.EstruturaEstatica;

public class Lista2 <T> extends EstruturaEstatica <T> {

	public Lista2(){
		super();
	}
	
	public Lista2(int capacidade){
		super(capacidade);
	}
	
	public boolean adiciona(T elemento){
		return super.adiciona(elemento);
	}
	
	public boolean adicionaPosicao(int posicao, T elemento){
		return super.adicionaPosicao(posicao, elemento);
	}
	
}
