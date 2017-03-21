package estruturasdados.vetor;

import java.lang.reflect.Array;

// <T> Esse recurso é chamado de Generics onde ele permite passar
// a classe qual é o tipo de vetor que a classe deve trabalhar
public class Lista<T> {

	private T[] elementos;
	private int tamanho;
	private static final int DOBRA = 2;
	
	public Lista(int capacidade) {
		this.elementos = (T[]) new Object [capacidade];
		this.tamanho = 0;
	}
	
	/*public Lista(int capacidade, Class<T> tipoClasse) {
		this.elementos = (T[]) Array.newInstance(tipoClasse, capacidade);
		this.tamanho = 0;
	}*/
	
	public boolean adiciona(T elemento){
		this.aumentaCapacidade();
		if(this.tamanho < this.elementos.length){
			this.elementos[this.tamanho] = elemento;
			this.tamanho ++;
			return true;
		}else{
			return false;
		}
	}
	
	// 0 1 2 3 4 5 6
	// B C E F G + +
	public void adicionaPosicao(int posicao, T elemento){
		if(!(posicao >= 0 && posicao < tamanho)){
			throw new IllegalArgumentException("Posição invalida");
		}
		
		this.aumentaCapacidade();
		
		// Move os elementos
		for (int i = this.tamanho - 1; i >= posicao; i--) {
			this.elementos[i+1] = this.elementos[i];
		}
		this.elementos[posicao] = elemento;
		this.tamanho++;
	}
	
	private void aumentaCapacidade(){
		if(this.tamanho == this.elementos.length){
			T[] copiaElementos =(T[]) new Object[this.elementos.length * DOBRA];
			for (int i = 0; i < this.elementos.length; i++) {
				copiaElementos[i] = this.elementos[i];
			}
			this.elementos = copiaElementos;
		}
	}
	
	// Exer04
	public T obtem(int posicao){
		return this.busca(posicao);
	}
	
	public T busca(int posicao){
		if(!(posicao >= 0 && posicao < tamanho)){
			throw new IllegalArgumentException("Posição invalida");
		}
		return this.elementos[posicao];
	}
	
	public int buscaIndice(T elemento){
		for (int i = 0; i < this.tamanho; i++) {
			if(this.elementos[i].equals(elemento)){
				return i;
			}
		}
		return -1;
	}
	
	// Exercicio01
	public boolean buscaContains(T elemento){
		return buscaIndice(elemento) > -1; //Essa forma faz a chamada do metodo buscaIndice fazendo com que a saída dele seja true ou false
	}
	
	public void remove(int posicao){
		if(!(posicao >= 0 && posicao < tamanho)){
			throw new IllegalArgumentException("Posição invalida");
		}
		
		for(int i = posicao; i < this.tamanho-1; i++){
			this.elementos[i] = this.elementos[i+1];
		}
		this.tamanho--;
	}
	
	// Exer03
	public void remove (T elemento){
		int pos = this.buscaIndice(elemento);
		if(pos > -1){
			this.remove(pos);
		}
	}
	
	// Exercicio02
	public int ultimoElemento(T elemento){
		for (int i = this.tamanho-1; i >= 0 ; i--) {
			if(this.elementos.equals(elemento)){
				return i;
			}
		}
		return -1;
	}
	
	public void limpar(){
		/*//opção1
		this.elementos = (T[])new Object[this.elementos.length];
		
		//opção2
		this.tamanho = 0;*/
		
		//opção3
		for (int i = 0; i < this.tamanho; i++) {
			this.elementos [i] = null;
		}
		this.tamanho = 0;
	}
	
	public int tamanho() {
		return this.tamanho;
	}

	public String toString() {
		
		StringBuilder s = new StringBuilder();
		s.append("[");
		
		for (int i = 0; i < this.tamanho-1; i++) {
			s.append(this.elementos[i]);
			s.append(", ");
		}
		
		if(this.tamanho > 0){
			s.append(this.elementos[this.tamanho-1]);
		}
		
		s.append("]");
		
		return s.toString();
	}
	
	
}
