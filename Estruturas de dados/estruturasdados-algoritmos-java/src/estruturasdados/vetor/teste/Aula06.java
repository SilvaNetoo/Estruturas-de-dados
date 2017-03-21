package estruturasdados.vetor.teste;

import estruturasdados.vetor.Vetor;

public class Aula06 {

	public static void main(String[] args) {
		
		Vetor vetor = new Vetor(10);
		
		vetor.adiciona("B");
		vetor.adiciona("C");
		vetor.adiciona("E");
		vetor.adiciona("F");
		vetor.adiciona("G");
		System.out.println(vetor.toString());
		vetor.adicionaPosicao(0,"A");
		System.out.println(vetor.toString());
		vetor.adicionaPosicao(3,"D");
		System.out.println(vetor.toString());
	}

}
