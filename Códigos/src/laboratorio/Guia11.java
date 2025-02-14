package laboratorio;

//Classe CelulaP genérica para representar um nó na pilha
class CelulaP<T> {
	T elemento;
	CelulaP<T> proximo;

	public CelulaP() {
		this.elemento = null;
		this.proximo = null;
	}

	public CelulaP(T elemento) {
		this.elemento = elemento;
		this.proximo = null;
	}
}

//Classe Pilha1: classe genérica para representar uma pilha encadeada
class Pilha1<T extends Number> {
	private CelulaP<T> topo;
	private int tamanho;

	public Pilha1() {
		this.topo = null;
		this.tamanho = 0;
	}

	public void empilha(T elemento) {
		CelulaP<T> nova = new CelulaP<>(elemento);
		nova.proximo = topo;
		topo = nova;
		tamanho++;
		System.out.println("Elemento " + elemento + " empilhado.");
	}

	public T desempilha() {
		if (pilhaVazia()) {
			throw new IllegalStateException("Pilha vazia!");
		}
		T removido = topo.elemento;
		topo = topo.proximo;
		tamanho--;
		System.out.println("Elemento " + removido + " desempilhado.");
		return removido;
	}

	public void mostrar() {
		if (pilhaVazia()) {
			System.out.println("Pilha vazia.");
			return;
		}
		System.out.print("Pilha: ");
		CelulaP<T> temp = topo;
		while (temp != null) {
			System.out.print(temp.elemento + " ");
			temp = temp.proximo;
		}
		System.out.println();
	}

	public void imprimirTamanho() {
		System.out.println("Tamanho da pilha: " + tamanho);
	}

	public boolean pilhaVazia() {
		return tamanho == 0;
	}

	public double somaIterativa() {
		double soma = 0;
		while (!pilhaVazia()) {
			soma += desempilha().doubleValue();
		}
		return soma;
	}
}

//Classe genérica para representar um nó na lista duplamente encadeada
class CelulaD<T> {
	T elemento;
	CelulaD<T> anterior, proximo;

	public CelulaD() {
		this.elemento = null;
		this.anterior = null;
		this.proximo = null;
	}

	public CelulaD(T elemento) {
		this.elemento = elemento;
		this.anterior = null;
		this.proximo = null;
	}
}

//Classe ListaD: classe genérica para representar uma lista duplamente encadeada
class ListaD<T> {
	private CelulaD<T> prim, ult;
	private int tamanho;

	public ListaD() {
		this.prim = new CelulaD<>(); // Sentinela
		this.ult = prim;
		this.tamanho = 0;
	}

	public void inserirInicio(T elemento) {
		CelulaD<T> nova = new CelulaD<>(elemento);
		nova.proximo = prim.proximo;
		nova.anterior = prim;
		if (prim.proximo != null) {
			prim.proximo.anterior = nova;
		} else {
			ult = nova;
		}
		prim.proximo = nova;
		tamanho++;
		System.out.println("Elemento " + elemento + " inserido no início.");
	}

	public void inserirFim(T elemento) {
		CelulaD<T> nova = new CelulaD<>(elemento);
		nova.anterior = ult;
		ult.proximo = nova;
		ult = nova;
		tamanho++;
		System.out.println("Elemento " + elemento + " inserido no fim.");
	}

	public T removerInicio() {
		if (listaVazia()) {
			throw new IllegalStateException("Lista vazia!");
		}
		CelulaD<T> removida = prim.proximo;
		prim.proximo = removida.proximo;
		if (prim.proximo != null) {
			prim.proximo.anterior = prim;
		} else {
			ult = prim;
		}
		tamanho--;
		System.out.println("Elemento " + removida.elemento + " removido do início.");
		return removida.elemento;
	}

	public T removerFim() {
		if (listaVazia()) {
			throw new IllegalStateException("Lista vazia!");
		}
		CelulaD<T> removida = ult;
		ult = removida.anterior;
		ult.proximo = null;
		tamanho--;
		System.out.println("Elemento " + removida.elemento + " removido do fim.");
		return removida.elemento;
	}

	public void mostrarInicioAoFim() {
		CelulaD<T> temp = prim.proximo;
		System.out.print("Lista do início ao fim: ");
		while (temp != null) {
			System.out.print(temp.elemento + " ");
			temp = temp.proximo;
		}
		System.out.println();
	}

	public void mostrarFimAoInicio() {
		CelulaD<T> temp = ult;
		System.out.print("Lista do fim ao início: ");
		while (temp != prim) {
			System.out.print(temp.elemento + " ");
			temp = temp.anterior;
		}
		System.out.println();
	}

	public void imprimirTamanho() {
		System.out.println("Tamanho da lista: " + tamanho);
	}

	public boolean listaVazia() {
		return tamanho == 0;
	}
}

//Classe principal para testes
public class Guia11 {
	public static void main(String[] args) {
		System.out.println("=== Testando Pilha ===");
		Pilha1<Integer> pilha = new Pilha1<>();
		pilha.empilha(10);
		pilha.empilha(20);
		pilha.empilha(30);
		pilha.empilha(40);
		pilha.imprimirTamanho();
		pilha.mostrar();
		System.out.println("Soma iterativa dos elementos: " + pilha.somaIterativa());
		pilha.imprimirTamanho();

		System.out.println("\n=== Testando Lista Duplamente Encadeada ===");
		ListaD<Integer> lista = new ListaD<>();
		lista.inserirInicio(50);
		lista.inserirInicio(60);
		lista.inserirFim(70);
		lista.inserirFim(80);
		lista.imprimirTamanho();
		lista.mostrarInicioAoFim();
		lista.mostrarFimAoInicio();
		lista.removerInicio();
		lista.removerFim();
		lista.imprimirTamanho();
		lista.mostrarInicioAoFim();
		lista.mostrarFimAoInicio();
		System.out.println("Lista está vazia? " + lista.listaVazia());
	}
}
