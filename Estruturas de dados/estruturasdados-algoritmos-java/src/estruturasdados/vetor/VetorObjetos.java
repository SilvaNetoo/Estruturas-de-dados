package estruturasdados.vetor;

public class VetorObjetos {

	private Object[] elementos;
	private int tamanho;
	private static final int DOBRA = 2;
	
	public VetorObjetos(int capacidade) {
		this.elementos = new Object [capacidade];
		this.tamanho = 0;
	}
	
	public boolean adiciona(Object elemento){
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
	public void adicionaPosicao(int posicao, Object elemento){
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
			Object[] copiaElementos = new Object[this.elementos.length * DOBRA];
			for (int i = 0; i < this.elementos.length; i++) {
				copiaElementos[i] = this.elementos[i];
			}
			this.elementos = copiaElementos;
		}
	}
	
	public Object busca(int posicao){
		if(!(posicao >= 0 && posicao < tamanho)){
			throw new IllegalArgumentException("Posição invalida");
		}
		return this.elementos[posicao];
	}
	
	public int buscaIndice(Object elemento){
		for (int i = 0; i < this.tamanho; i++) {
			if(this.elementos[i].equals(elemento)){
				return i;
			}
		}
		return -1;
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
