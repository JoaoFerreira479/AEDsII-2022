package laboratorio;

//Classe Node: representa um nó genérico na lista encadeada
class Node<T> {
	T item; // Valor armazenado no nó
	Node<T> next; // Referência para o próximo nó

	public Node(T item) {
		this.item = item;
		this.next = null;
	}
}

//Classe Fila1: implementação genérica de uma fila usando lista encadeada
class Fila1<T> {
	private Node<T> front; // Referência para o início da fila
	private Node<T> rear; // Referência para o final da fila
	private int size; // Tamanho da fila

	// Construtor
	public Fila1() {
		this.front = null;
		this.rear = null;
		this.size = 0;
	}

	// Método para enfileirar (inserir) um elemento na fila
	public void enfileirar(T item) {
		Node<T> newNode = new Node<>(item); // Cria um novo nó com o valor fornecido
		if (rear == null) { // Caso a fila esteja vazia
			front = rear = newNode;
		} else { // Caso contrário, adiciona ao final
			rear.next = newNode;
			rear = newNode;
		}
		size++;
		System.out.println("Elemento " + item + " adicionado à fila.");
	}

	// Método para desenfileirar (remover) um elemento da fila
	public T desenfileirar() {
		if (isEmpty()) { // Verifica se a fila está vazia
			throw new IllegalStateException("A fila está vazia. Não é possível remover elementos.");
		}
		T removedItem = front.item; // Armazena o valor a ser removido
		front = front.next; // Move o início da fila para o próximo nó
		if (front == null) { // Caso a fila fique vazia
			rear = null;
		}
		size--;
		System.out.println("Elemento " + removedItem + " removido da fila.");
		return removedItem;
	}

	// Método para mostrar todos os elementos da fila
	public void mostrarFila() {
		if (isEmpty()) {
			System.out.println("A fila está vazia.");
			return;
		}
		System.out.print("Fila: ");
		Node<T> current = front;
		while (current != null) {
			System.out.print(current.item + " ");
			current = current.next;
		}
		System.out.println();
	}

	// Método para verificar se a fila está vazia
	public boolean isEmpty() {
		return size == 0;
	}

	// Método para retornar o tamanho da fila
	public int getTamanho() {
		return size;
	}

	// Método para limpar a fila
	public void clear() {
		front = null;
		rear = null;
		size = 0;
		System.out.println("A fila foi esvaziada.");
	}

	// Método para acessar o elemento no início da fila
	public T getFront() {
		if (isEmpty()) {
			throw new IllegalStateException("A fila está vazia. Não há elemento no início.");
		}
		return front.item;
	}

	// Método para acessar o elemento no final da fila
	public T getRear() {
		if (isEmpty()) {
			throw new IllegalStateException("A fila está vazia. Não há elemento no final.");
		}
		return rear.item;
	}
}

//Classe principal para testes
public class Guia8 {
	public static void main(String[] args) {
		Fila1<Integer> fila = new Fila1<>();

		// Testando enfileirar
		fila.enfileirar(10);
		fila.enfileirar(20);
		fila.enfileirar(30);

		// Mostrando a fila
		fila.mostrarFila();

		// Acessando o início e o final da fila
		System.out.println("Primeiro elemento: " + fila.getFront());
		System.out.println("Último elemento: " + fila.getRear());

		// Removendo elementos da fila
		fila.desenfileirar();
		fila.mostrarFila();

		// Verificando se a fila está vazia
		System.out.println("A fila está vazia? " + fila.isEmpty());

		// Obtendo o tamanho da fila
		System.out.println("Tamanho da fila: " + fila.getTamanho());

		// Removendo os últimos elementos
		fila.desenfileirar();
		fila.desenfileirar();
		fila.mostrarFila();

		// Verificando novamente se a fila está vazia
		System.out.println("A fila está vazia? " + fila.isEmpty());

		// Testando a limpeza da fila
		fila.enfileirar(40);
		fila.enfileirar(50);
		fila.mostrarFila();
		fila.clear();
		fila.mostrarFila();
	}
}
