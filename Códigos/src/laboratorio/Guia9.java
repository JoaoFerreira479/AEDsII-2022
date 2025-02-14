package laboratorio;

//Classe Celula genérica para representar um nó na lista encadeada
class Celula<T> {
	T elemento; // Valor armazenado no nó
	Celula<T> prox; // Referência para o próximo nó

	public Celula(T elemento) {
		this.elemento = elemento;
		this.prox = null;
	}
}

//Classe Lista2: implementação genérica de uma lista encadeada
class Lista2<T> {
	private Celula<T> inicio; // Referência para o primeiro nó
	private Celula<T> fim; // Referência para o último nó
	private int tamanho; // Número de elementos na lista

	// Construtor da lista
	public Lista2() {
		this.inicio = null;
		this.fim = null;
		this.tamanho = 0;
	}

	public void inserirInicio(T elemento) {
		Celula<T> nova = new Celula<>(elemento);
		if (estaVazia()) {
			inicio = fim = nova;
		} else {
			nova.prox = inicio;
			inicio = nova;
		}
		tamanho++;
		System.out.println("Elemento " + elemento + " inserido no início.");
	}

	public void inserirFim(T elemento) {
		Celula<T> nova = new Celula<>(elemento);
		if (estaVazia()) {
			inicio = fim = nova;
		} else {
			fim.prox = nova;
			fim = nova;
		}
		tamanho++;
		System.out.println("Elemento " + elemento + " inserido no fim.");
	}

	public void inserirNaPosicao(T elemento, int pos) {
		if (pos < 0 || pos > tamanho) {
			throw new IllegalArgumentException("Posição inválida!");
		}
		if (pos == 0) {
			inserirInicio(elemento);
			return;
		}
		if (pos == tamanho) {
			inserirFim(elemento);
			return;
		}
		Celula<T> nova = new Celula<>(elemento);
		Celula<T> temp = inicio;
		for (int i = 0; i < pos - 1; i++) {
			temp = temp.prox;
		}
		nova.prox = temp.prox;
		temp.prox = nova;
		tamanho++;
		System.out.println("Elemento " + elemento + " inserido na posição " + pos + ".");
	}

	public T removerInicio() {
		if (estaVazia()) {
			throw new IllegalStateException("Lista vazia!");
		}
		T removido = inicio.elemento;
		inicio = inicio.prox;
		if (inicio == null) {
			fim = null;
		}
		tamanho--;
		System.out.println("Elemento " + removido + " removido do início.");
		return removido;
	}

	public T removerFim() {
		if (estaVazia()) {
			throw new IllegalStateException("Lista vazia!");
		}
		if (inicio == fim) {
			T removido = inicio.elemento;
			inicio = fim = null;
			tamanho--;
			System.out.println("Elemento " + removido + " removido do fim.");
			return removido;
		}
		Celula<T> temp = inicio;
		while (temp.prox != fim) {
			temp = temp.prox;
		}
		T removido = fim.elemento;
		fim = temp;
		fim.prox = null;
		tamanho--;
		System.out.println("Elemento " + removido + " removido do fim.");
		return removido;
	}

	public T removerNaPosicao(int pos) {
		if (pos < 0 || pos >= tamanho) {
			throw new IllegalArgumentException("Posição inválida!");
		}
		if (pos == 0) {
			return removerInicio();
		}
		if (pos == tamanho - 1) {
			return removerFim();
		}
		Celula<T> temp = inicio;
		for (int i = 0; i < pos - 1; i++) {
			temp = temp.prox;
		}
		T removido = temp.prox.elemento;
		temp.prox = temp.prox.prox;
		tamanho--;
		System.out.println("Elemento " + removido + " removido da posição " + pos + ".");
		return removido;
	}

	public void mostrar() {
		if (estaVazia()) {
			System.out.println("Lista vazia.");
			return;
		}
		System.out.print("Lista: ");
		Celula<T> temp = inicio;
		while (temp != null) {
			System.out.print(temp.elemento + " ");
			temp = temp.prox;
		}
		System.out.println();
	}

	public int imprimirTamanho() {
		System.out.println("Tamanho da lista: " + tamanho);
		return tamanho;
	}

	public boolean estaVazia() {
		return tamanho == 0;
	}

	// Soma iterativa dos elementos da lista (apenas números)
	public double somarIterativo() {
		double soma = 0;
		Celula<T> temp = inicio;
		while (temp != null) {
			soma += Double.parseDouble(temp.elemento.toString());
			temp = temp.prox;
		}
		return soma;
	}

	// Soma recursiva dos elementos da lista (apenas números)
	public double somarRecursivo() {
		return somarRecursivoAux(inicio);
	}

	private double somarRecursivoAux(Celula<T> celula) {
		if (celula == null) {
			return 0;
		}
		return Double.parseDouble(celula.elemento.toString()) + somarRecursivoAux(celula.prox);
	}
}

//Classe principal para testes
public class Guia9 {
	public static void main(String[] args) {
		Lista2<Integer> lista = new Lista2<>();

		// Inserções na lista
		lista.inserirInicio(10);
		lista.inserirInicio(20);
		lista.inserirFim(30);
		lista.inserirFim(40);
		lista.inserirNaPosicao(15, 1);
		lista.inserirNaPosicao(50, lista.imprimirTamanho());
		lista.inserirNaPosicao(25, 4);
		lista.mostrar();

		// Remoções na lista
		lista.removerInicio();
		lista.mostrar();
		lista.removerFim();
		lista.mostrar();
		lista.removerNaPosicao(3);
		lista.mostrar();

		// Soma dos elementos
		System.out.println("Soma iterativa: " + lista.somarIterativo());
		System.out.println("Soma recursiva: " + lista.somarRecursivo());
	}
}
