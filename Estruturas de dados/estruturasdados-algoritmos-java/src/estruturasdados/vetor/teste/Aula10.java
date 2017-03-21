package estruturasdados.vetor.teste;

import estruturasdados.vetor.VetorObjetos;

public class Aula10 {

	public static void main(String[] args) {

		VetorObjetos vetor = new VetorObjetos(3);
		
		Contato c1 = new Contato("contato 01", "1234-5678", "silva.neto@gmail.com");
		Contato c2 = new Contato("contato 02", "2345-6789", "phulano@gmail.com");
		Contato c3 = new Contato("contato 03", "3456-7890", "dethal@gmail.com");
		Contato c4 = new Contato("contato 01", "1234-5678", "silva.neto@gmail.com");
		vetor.adiciona(c1);
		vetor.adiciona(c2);
		vetor.adiciona(c3);
		
		System.out.println("tamanho = " + vetor.tamanho());
		
		int pos = vetor.buscaIndice(c4);
		if (pos > -1) {
			System.out.println("Elemento existe no vetor");
		}else{
			System.out.println("ELemento não existe no vetor");
		}
		
		System.out.println(vetor);
	}

}
