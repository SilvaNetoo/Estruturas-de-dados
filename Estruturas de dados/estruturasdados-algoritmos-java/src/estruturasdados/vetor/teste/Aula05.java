package estruturasdados.vetor.teste;

import estruturasdados.vetor.Vetor;

public class Aula05 {

	public static void main(String[] args) {

		Vetor vetor = new Vetor(10);
		
		vetor.adiciona("Elemento01");
		vetor.adiciona("Elemento02");
		vetor.adiciona("Elemento03");
		
		System.out.println(vetor.busca(1));
	}

}
