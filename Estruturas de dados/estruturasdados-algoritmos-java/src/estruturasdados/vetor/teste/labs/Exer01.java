package estruturasdados.vetor.teste.labs;

import estruturasdados.vetor.Lista;

public class Exer01 {

	public static void main(String[] args) {

		Lista<String> lista = new Lista<String>(5);
		
		lista.adiciona("A");
		lista.adiciona("B");
		lista.adiciona("C");
		
		System.out.println(lista.buscaContains("A"));
		System.out.println(lista.buscaContains("B"));
		System.out.println(lista.buscaContains("C"));
		System.out.println(lista.buscaContains("E"));
	}

}
