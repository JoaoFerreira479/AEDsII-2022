package laboratorio;

import java.util.Arrays;

//Classe Lista: implementação genérica para listas sequenciais
class Lista<T> {
	private T[] array;
	private int n;

	@SuppressWarnings("unchecked")
	public Lista(int capacidade) {
		this.array = (T[]) new Object[capacidade];
		this.n = 0;
	}

	public void inserirPrimeiraPosicao(T x) {
		if (n >= array.length) {
			throw new IllegalStateException("Vetor cheio!");
		}
		for (int i = n; i > 0; i--) {
			array[i] = array[i - 1];
		}
		array[0] = x;
		n++;
	}

	public void inserirUltimaPosicao(T x) {
		if (n >= array.length) {
			throw new IllegalStateException("Vetor cheio!");
		}
		array[n++] = x;
	}

	public void inserirNaPosicao(T x, int pos) {
		if (n >= array.length) {
			throw new IllegalStateException("Vetor cheio!");
		}
		if (pos < 0 || pos > n) {
			throw new IndexOutOfBoundsException("Posição inválida!");
		}
		for (int i = n; i > pos; i--) {
			array[i] = array[i - 1];
		}
		array[pos] = x;
		n++;
	}

	public T removerPrimeiraPosicao() {
		if (n == 0) {
			throw new IllegalStateException("Vetor vazio!");
		}
		T removido = array[0];
		for (int i = 0; i < n - 1; i++) {
			array[i] = array[i + 1];
		}
		n--;
		return removido;
	}

	public T removerUltimaPosicao() {
		if (n == 0) {
			throw new IllegalStateException("Vetor vazio!");
		}
		return array[--n];
	}

	public T removerNaPosicao(int pos) {
		if (n == 0) {
			throw new IllegalStateException("Vetor vazio!");
		}
		if (pos < 0 || pos >= n) {
			throw new IndexOutOfBoundsException("Posição inválida!");
		}
		T removido = array[pos];
		for (int i = pos; i < n - 1; i++) {
			array[i] = array[i + 1];
		}
		n--;
		return removido;
	}

	public void imprimir() {
		System.out.println("Elementos válidos: " + Arrays.toString(Arrays.copyOf(array, n)));
	}
}

//Classe Pilha: herda de Lista e adiciona métodos push e pop
class Pilha<T> extends Lista<T> {
	public Pilha(int capacidade) {
		super(capacidade);
	}

	public void push(T x) {
		inserirUltimaPosicao(x);
	}

	public T pop() {
		return removerUltimaPosicao();
	}
}

//Classe Fila: herda de Lista e adiciona métodos enqueue e dequeue
class Fila<T> extends Lista<T> {
	public Fila(int capacidade) {
		super(capacidade);
	}

	public void enqueue(T x) {
		inserirUltimaPosicao(x);
	}

	public T dequeue() {
		return removerPrimeiraPosicao();
	}
}

//Classe principal para testes
public class Guia7 {
	public static void main(String[] args) {
		testarLista();
		testarPilha();
		testarFila();
	}

	private static void testarLista() {
		Lista<Integer> lista = new Lista<>(10);
		System.out.println("Testando Lista:");
		for (int i = 1; i <= 5; i++) {
			lista.inserirUltimaPosicao(i);
			lista.imprimir();
		}
		for (int i = 0; i < 5; i++) {
			lista.removerPrimeiraPosicao();
			lista.imprimir();
		}
	}

	private static void testarPilha() {
		Pilha<Integer> pilha = new Pilha<>(10);
		System.out.println("\nTestando Pilha:");
		for (int i = 1; i <= 5; i++) {
			pilha.push(i);
			pilha.imprimir();
		}
		for (int i = 0; i < 5; i++) {
			pilha.pop();
			pilha.imprimir();
		}
	}

	private static void testarFila() {
		Fila<Integer> fila = new Fila<>(10);
		System.out.println("\nTestando Fila:");
		for (int i = 1; i <= 5; i++) {
			fila.enqueue(i);
			fila.imprimir();
		}
		for (int i = 0; i < 5; i++) {
			fila.dequeue();
			fila.imprimir();
		}
	}
}
