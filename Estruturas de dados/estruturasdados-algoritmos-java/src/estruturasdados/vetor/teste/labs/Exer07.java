package estruturasdados.vetor.teste.labs;

import java.util.ArrayList;
import java.util.Scanner;

import estruturasdados.vetor.teste.Contato;

public class Exer07 extends Exer06{

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		ArrayList<Contato> lista = new ArrayList<Contato>(20);
		criarContatoDinamicamente(2, lista);
		int opcao = 1;

		while(opcao != 0){
			opcao = obterOpcaoMenu(teclado);

			switch (opcao) {
			case 1:
				adicionarContatoFinal(teclado, lista);
				break;
			case 2:
				adicionarContatoPosicao(teclado, lista);
				break;
			case 3:
				obtemContatoPosicao(teclado, lista);
				break;
			case 4:
				obtemContato(teclado, lista);
				break;
			case 5:
				pesquisarUltimoIndice(teclado, lista);
				break;
			case 6:
				pesquisarContatoExiste(teclado, lista);
				break;
			case 7:
				excluirPorPosicao(teclado, lista);
				break;
			case 8:
				excluirContato(teclado, lista);
				break;
			case 9:
				imprimirTamanhoVetor(lista);
				break;
			case 10:
				limparVetor(lista);
				break;
			case 11:
				imprimirVetor(lista);
				break;
			default:
				break;
			}
		}
		System.out.println("Usuário digitou 0, programa finalizado");
	}
	
	private static void imprimirVetor(ArrayList<Contato> lista){
		System.out.println(lista);
	}
	
	private static void limparVetor(ArrayList<Contato> lista){
		lista.clear();
		System.out.println("todos os contatos do vetor foram excluidos");
	}
	
	private static void imprimirTamanhoVetor(ArrayList<Contato> lista){
		System.out.println("Tamanho do vetor é: "+lista.size());
	}
	
	private static void excluirContato(Scanner teclado, ArrayList<Contato> lista){
		int pos = leInformacaoInt("entre com a posição a ser removida", teclado);

		try {
			
			Contato contato = lista.get(pos);
			
			lista.remove(contato);
			
			System.out.println("Contato Excluido!");
			
			} catch (Exception e) {
			System.out.println("Entrada inválida");
		}
	}
	
	private static void excluirPorPosicao(Scanner teclado, ArrayList<Contato> lista){
		int pos = leInformacaoInt("entre com a posição a ser removida", teclado);

		try {
			
			lista.remove(pos);
			
			System.out.println("Contato Excluido!");
			
			} catch (Exception e) {
			System.out.println("Entrada inválida");
		}
	}
	
	private static void pesquisarContatoExiste(Scanner teclado, ArrayList<Contato> lista){
		int pos = leInformacaoInt("entre com a posição de pesquisa desejada", teclado);

		try {
			Contato contato = lista.get(pos);

			boolean existe = lista.contains(contato);
			
			if(existe){
				System.out.println("Contato existe, segue os dados: ");
				System.out.println(contato);
			}else{
				System.out.println("Contato não existe");
			}
			System.out.println("Contato encontrado na posição: "+ pos);
		} catch (Exception e) {
			System.out.println("Entrada inválida");
		}
	}
	
	private static void pesquisarUltimoIndice(Scanner teclado, ArrayList<Contato> lista){
		int pos = leInformacaoInt("entre com a posição de pesquisa desejada", teclado);

		try {
			Contato contato = lista.get(pos);
			System.out.println("Contato existe, segue os dados: ");
			System.out.println(contato);

			System.out.println("Fazendo pesquisa do ultimo indide contato encontrado:");
			pos = lista.lastIndexOf(contato);

			System.out.println("Contato encontrado na posição: "+ pos);
		} catch (Exception e) {
			System.out.println("Entrada inválida");
		}
	}

	private static void obtemContato(Scanner teclado, ArrayList<Contato> lista){
		int pos = leInformacaoInt("entre com a posição de pesquisa desejada", teclado);

		try {
			Contato contato = lista.get(pos);
			System.out.println("Contato existe, segue os dados: ");
			System.out.println(contato);

			System.out.println("Fazendo pesquisa do contato encontrado:");
			pos = lista.indexOf(contato);

			System.out.println("Contato encontrado na posição: "+ pos);
		} catch (Exception e) {
			System.out.println("Entrada inválida");
		}
	}

	private static void obtemContatoPosicao(Scanner teclado, ArrayList<Contato> lista){
		int pos = leInformacaoInt("entre com a posição de pesquisa desejada", teclado);

		try {
			Contato contato = lista.get(pos);
			System.out.println("Contato existe, segue os dados");
			System.out.println(contato);			
		} catch (Exception e) {
			System.out.println("Entrada inválida");
		}
	}

	private static void adicionarContatoFinal(Scanner teclado, ArrayList<Contato> lista){
		System.out.println("Criando um contato, entre com as informações");
		String nome = leInformacao("Entre com o nome", teclado);
		String telefone = leInformacao("entre com o telefone", teclado);
		String email = leInformacao("Entre com o email", teclado);

		Contato contato = new Contato(nome, telefone, email);

		lista.add(contato);

		System.out.println("Contato adicionado com sucesso!");
		System.out.println(contato);
	}

	private static void adicionarContatoPosicao(Scanner teclado, ArrayList<Contato> lista){
		System.out.println("Criando um contato, entre com as informações");
		String nome = leInformacao("Entre com o nome", teclado);
		String telefone = leInformacao("entre com o telefone", teclado);
		String email = leInformacao("Entre com o email", teclado);

		Contato contato = new Contato(nome, telefone, email);

		int pos = leInformacaoInt("Digite a posição em que o contato irá ser adicionado", teclado);

		try {
			lista.add(pos, contato);
			System.out.println("Contato adicionado com sucesso!");
			System.out.println(contato);
		} catch (Exception e) {
			System.out.println("Posição inválida, contato não adicionado");
		}		
	}
	
	private static void criarContatoDinamicamente(int quantidade, ArrayList<Contato> lista){
		Contato contato;

		for (int i = 1; i <= quantidade; i++) {
			contato = new Contato();
			contato.setNome("Contato"+i);
			contato.setTelefone("1111111"+i);
			contato.setEmail("Contato"+i+"@gmail.com");
			
			lista.add(contato);
		}
	}
}
