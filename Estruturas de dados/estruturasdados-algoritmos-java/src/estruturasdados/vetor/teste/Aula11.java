package estruturasdados.vetor.teste;

import estruturasdados.vetor.Lista;
import estruturasdados.vetor.VetorObjetos;

public class Aula11 {

	public static void main(String[] args) {

		Lista<Contato> vetor = new Lista<Contato>(1);
		
		Contato c1 = new Contato("contato 01", "1234-5678", "silva.neto@gmail.com");
		Contato c2 = new Contato("contato 02", "2345-6789", "phulano@gmail.com");
		Contato c3 = new Contato("contato 03", "3456-7890", "dethal@gmail.com");
		
		vetor.adiciona(c1);
	}

}
