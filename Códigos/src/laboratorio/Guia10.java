package laboratorio;

//Classe Celula2 genérica para representar um nó na lista encadeada
class Celula2<T> {
	T elemento; // Valor armazenado no nó
	Celula2<T> proximo; // Referência para o próximo nó

	public Celula2() {
		this.elemento = null;
		this.proximo = null;
	}

	public Celula2(T elemento) {
		this.elemento = elemento;
		this.proximo = null;
	}
}

//Classe Lista3: implementação genérica de uma lista encadeada com sentinela
class Lista3<T> {
	private Celula2<T> prim; // Sentinela para o início da lista
	private Celula2<T> ult; // Referência para o último nó
	private int tamanho; // Número de elementos na lista

	// Construtor da lista
	public Lista3() {
		this.prim = new Celula2<>(); // Sentinela
		this.ult = prim;
		this.tamanho = 0;
	}

	public void inserirInicio(T elemento) {
		Celula2<T> nova = new Celula2<>(elemento);
		nova.proximo = prim.proximo;
		prim.proximo = nova;
		if (tamanho == 0) {
			ult = nova;
		}
		tamanho++;
		System.out.println("Inserido no início: " + elemento);
	}

	public void inserirFim(T elemento) {
		Celula2<T> nova = new Celula2<>(elemento);
		ult.proximo = nova;
		ult = nova;
		tamanho++;
		System.out.println("Inserido no fim: " + elemento);
	}

	public T removerInicio() {
		if (listaVazia()) {
			throw new IllegalStateException("Lista está vazia!");
		}
		Celula2<T> removida = prim.proximo;
		prim.proximo = removida.proximo;
		if (prim.proximo == null) {
			ult = prim;
		}
		tamanho--;
		System.out.println("Removido do início: " + removida.elemento);
		return removida.elemento;
	}

	public void mostrar() {
		if (listaVazia()) {
			System.out.println("Lista vazia.");
			return;
		}
		System.out.println("Elementos da lista:");
		Celula2<T> temp = prim.proximo;
		while (temp != null) {
			System.out.println(temp.elemento);
			temp = temp.proximo;
		}
	}

	public void imprimirTamanho() {
		System.out.println("Tamanho da lista: " + tamanho);
	}

	public boolean listaVazia() {
		return tamanho == 0;
	}

	// Método iterativo para calcular a média (apenas para listas numéricas)
	public double calcularMediaIterativa() {
		if (listaVazia()) {
			return 0;
		}
		if (!(prim.proximo.elemento instanceof Number)) {
			throw new UnsupportedOperationException("A média só pode ser calculada para listas numéricas.");
		}
		double soma = 0;
		int count = 0;
		Celula2<T> temp = prim.proximo;
		while (temp != null) {
			soma += ((Number) temp.elemento).doubleValue();
			count++;
			temp = temp.proximo;
		}
		return soma / count;
	}

	// Método recursivo para calcular a média (apenas para listas numéricas)
	public double calcularMediaRecursiva() {
		if (listaVazia()) {
			return 0;
		}
		if (!(prim.proximo.elemento instanceof Number)) {
			throw new UnsupportedOperationException("A média só pode ser calculada para listas numéricas.");
		}
		return calcularMediaRecursivaAux(prim.proximo, 0, 0);
	}

	private double calcularMediaRecursivaAux(Celula2<T> celula, double soma, int count) {
		if (celula == null) {
			return soma / count;
		}
		return calcularMediaRecursivaAux(celula.proximo, soma + ((Number) celula.elemento).doubleValue(), count + 1);
	}
}

//Classe principal para testes
public class Guia10 {
	public static void main(String[] args) {
		Lista3<String> listaStrings = new Lista3<>();
		listaStrings.inserirInicio("Alice");
		listaStrings.inserirInicio("Bob");
		listaStrings.inserirFim("Charlie");
		listaStrings.mostrar();
		listaStrings.removerInicio();
		listaStrings.mostrar();

		Lista3<Integer> listaNumeros = new Lista3<>();
		listaNumeros.inserirInicio(10);
		listaNumeros.inserirFim(20);
		listaNumeros.inserirFim(30);
		listaNumeros.mostrar();
		System.out.println("Média iterativa: " + listaNumeros.calcularMediaIterativa());
		System.out.println("Média recursiva: " + listaNumeros.calcularMediaRecursiva());
	}
}
