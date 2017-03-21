package estruturasdados.vetor.teste.labs;

import java.util.Scanner;

import estruturasdados.vetor.Lista;
import estruturasdados.vetor.teste.Contato;

public class Exer06 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		Lista<Contato> lista = new Lista<Contato>(20);
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
	
	private static void imprimirVetor(Lista<Contato> lista){
		System.out.println(lista);
	}
	
	private static void limparVetor(Lista<Contato> lista){
		lista.limpar();
		System.out.println("todos os contatos do vetor foram excluidos");
	}
	
	private static void imprimirTamanhoVetor(Lista<Contato> lista){
		System.out.println("Tamanho do vetor é: "+lista.tamanho());
	}
	
	private static void excluirContato(Scanner teclado, Lista<Contato> lista){
		int pos = leInformacaoInt("entre com a posição a ser removida", teclado);

		try {
			
			Contato contato = lista.busca(pos);
			
			lista.remove(contato);
			
			System.out.println("Contato Excluido!");
			
			} catch (Exception e) {
			System.out.println("Entrada inválida");
		}
	}
	
	private static void excluirPorPosicao(Scanner teclado, Lista<Contato> lista){
		int pos = leInformacaoInt("entre com a posição a ser removida", teclado);

		try {
			
			lista.remove(pos);
			
			System.out.println("Contato Excluido!");
			
			} catch (Exception e) {
			System.out.println("Entrada inválida");
		}
	}
	
	private static void pesquisarContatoExiste(Scanner teclado, Lista<Contato> lista){
		int pos = leInformacaoInt("entre com a posição de pesquisa desejada", teclado);

		try {
			Contato contato = lista.busca(pos);

			boolean existe = lista.buscaContains(contato);
			
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
	
	private static void pesquisarUltimoIndice(Scanner teclado, Lista<Contato> lista){
		int pos = leInformacaoInt("entre com a posição de pesquisa desejada", teclado);

		try {
			Contato contato = lista.busca(pos);
			System.out.println("Contato existe, segue os dados: ");
			System.out.println(contato);

			System.out.println("Fazendo pesquisa do ultimo indide contato encontrado:");
			pos = lista.ultimoElemento(contato);

			System.out.println("Contato encontrado na posição: "+ pos);
		} catch (Exception e) {
			System.out.println("Entrada inválida");
		}
	}

	private static void obtemContato(Scanner teclado, Lista<Contato> lista){
		int pos = leInformacaoInt("entre com a posição de pesquisa desejada", teclado);

		try {
			Contato contato = lista.busca(pos);
			System.out.println("Contato existe, segue os dados: ");
			System.out.println(contato);

			System.out.println("Fazendo pesquisa do contato encontrado:");
			pos = lista.buscaIndice(contato);

			System.out.println("Contato encontrado na posição: "+ pos);
		} catch (Exception e) {
			System.out.println("Entrada inválida");
		}
	}

	private static void obtemContatoPosicao(Scanner teclado, Lista<Contato> lista){
		int pos = leInformacaoInt("entre com a posição de pesquisa desejada", teclado);

		try {
			Contato contato = lista.busca(pos);
			System.out.println("Contato existe, segue os dados");
			System.out.println(contato);			
		} catch (Exception e) {
			System.out.println("Entrada inválida");
		}
	}

	private static void adicionarContatoFinal(Scanner teclado, Lista<Contato> lista){
		System.out.println("Criando um contato, entre com as informações");
		String nome = leInformacao("Entre com o nome", teclado);
		String telefone = leInformacao("entre com o telefone", teclado);
		String email = leInformacao("Entre com o email", teclado);

		Contato contato = new Contato(nome, telefone, email);

		lista.adiciona(contato);

		System.out.println("Contato adicionado com sucesso!");
		System.out.println(contato);
	}

	private static void adicionarContatoPosicao(Scanner teclado, Lista<Contato> lista){
		System.out.println("Criando um contato, entre com as informações");
		String nome = leInformacao("Entre com o nome", teclado);
		String telefone = leInformacao("entre com o telefone", teclado);
		String email = leInformacao("Entre com o email", teclado);

		Contato contato = new Contato(nome, telefone, email);

		int pos = leInformacaoInt("Digite a posição em que o contato irá ser adicionado", teclado);

		try {
			lista.adicionaPosicao(pos, contato);
			System.out.println("Contato adicionado com sucesso!");
			System.out.println(contato);
		} catch (Exception e) {
			System.out.println("Posição inválida, contato não adicionado");
		}		
	}

	protected static String leInformacao(String msn, Scanner teclado){
		System.out.println(msn);
		String entrada = teclado.nextLine();

		return entrada;
	}

	protected static int leInformacaoInt(String msn, Scanner teclado){
		boolean entradaValida = false;
		int num = 0;
		while(!entradaValida){
			try{
				System.out.println(msn);
				String entrada = teclado.nextLine();
				num = Integer.parseInt(entrada);

				entradaValida = true;
			}catch(Exception e){
				System.out.println("Entrada invalida, tente novamente.");
			}
		}

		return num;
	}

	protected static int obterOpcaoMenu(Scanner teclado){

		boolean entradaValida = false;
		String entrada;
		int opcao = 0;

		while(!entradaValida){
			System.out.println("Digite a opção desejada: ");
			System.out.println("1: Adiciona contato no final do vetor");
			System.out.println("2: Adiciona contato em uma posição especifica");
			System.out.println("3: Obtem contato de uma posição especifica");
			System.out.println("4: Consulta contato");
			System.out.println("5: Consulta útimo indice do contato");
			System.out.println("6: Verifica se contato existe");
			System.out.println("7: Excluir contato por posição");
			System.out.println("8: Excluir contato");
			System.out.println("9: Verifica tamanho do vetor");
			System.out.println("10: Excluir todos os contatos do vetor");
			System.out.println("11: Imprime vetor");
			System.out.println("0: Sair");

			try{
				entrada = teclado.nextLine();
				opcao = Integer.parseInt(entrada);

				if(opcao >= 0 && opcao <=11){
					entradaValida = true;
				} else{
					throw new Exception();
				}

			} catch(Exception e){
				System.out.println("Entrada digitada é invalida, digite novamente\n\n");
			}

		}
		return opcao;
	}

	protected static void criarContatoDinamicamente(int quantidade, Lista<Contato> lista){
		Contato contato;

		for (int i = 1; i <= quantidade; i++) {
			contato = new Contato();
			contato.setNome("Contato"+i);
			contato.setTelefone("1111111"+i);
			contato.setEmail("Contato"+i+"@gmail.com");
			
			lista.adiciona(contato);
		}
	}
}
