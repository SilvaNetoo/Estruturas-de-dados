package estruturasdados.base;

public class EstruturaEstatica <T>{

	protected T[] elementos;
	protected int tamanho;
	protected static final int DOBRA = 2;
	
	public EstruturaEstatica(int capacidade){
		this.elementos = (T[]) new Object[capacidade];
		this.tamanho = 0;
	}
	
	public EstruturaEstatica(){
		this(10);
	}
	
	protected boolean adiciona(T elemento){
		this.aumentaCapacidade();
		if(this.tamanho < this.elementos.length){
			this.elementos[this.tamanho] = elemento;
			this.tamanho ++;
			return true;
		}else{
			return false;
		}
	}
	
	protected boolean adicionaPosicao(int posicao, T elemento){
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
		
		return true;
	}
	
	protected void aumentaCapacidade(){
		if(this.tamanho == this.elementos.length){
			T[] copiaElementos =(T[]) new Object[this.elementos.length * DOBRA];
			for (int i = 0; i < this.elementos.length; i++) {
				copiaElementos[i] = this.elementos[i];
			}
			this.elementos = copiaElementos;
		}
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
