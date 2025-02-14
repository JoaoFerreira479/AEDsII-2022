package laboratorio;

import java.util.Random;

public class Guia6 {
	public static void main(String[] args) {

		// Geração do vetor
		System.out.println("Gerando vetor aleatório...");
		long inicio = System.currentTimeMillis();
		double[] vetor = geraAleatorio(1_000_000);
		long fim = System.currentTimeMillis();
		System.out.printf("Tempo para gerar vetor: %.5f segundos%n", (fim - inicio) / 1000.0);

		exibirAmostra(vetor, "Vetor gerado", 10);

		// QuickSort
		System.out.println("\nOrdenando com QuickSort...");
		double[] vetorQuickSort = vetor.clone();
		inicio = System.currentTimeMillis();
		quickSort(vetorQuickSort, 0, vetorQuickSort.length - 1);
		fim = System.currentTimeMillis();
		System.out.printf("Tempo para QuickSort: %.5f segundos%n", (fim - inicio) / 1000.0);
		exibirAmostra(vetorQuickSort, "Vetor ordenado com QuickSort", 10);

		// HeapSort
		System.out.println("\nOrdenando com HeapSort...");
		double[] vetorHeapSort = vetor.clone();
		inicio = System.currentTimeMillis();
		heapSort(vetorHeapSort);
		fim = System.currentTimeMillis();
		System.out.printf("Tempo para HeapSort: %.5f segundos%n", (fim - inicio) / 1000.0);
		exibirAmostra(vetorHeapSort, "Vetor ordenado com HeapSort", 10);
	}

	// Gera um vetor de números aleatórios
	public static double[] geraAleatorio(int tamanho) {
		Random random = new Random();
		double[] vetor = new double[tamanho];
		for (int i = 0; i < tamanho; i++) {
			vetor[i] = random.nextDouble();
		}
		return vetor;
	}

	public static void exibirAmostra(double[] vetor, String descricao, int quantidade) {
		System.out.printf("\n%s (primeiros %d elementos):%n", descricao, quantidade);
		for (int i = 0; i < Math.min(quantidade, vetor.length); i++) {
			System.out.printf("%.5f ", vetor[i]);
		}
		System.out.println();
	}

	// Implementação do algoritmo QuickSort
	public static void quickSort(double[] vetor, int inicio, int fim) {
		if (inicio < fim) {
			int pivoIndex = partition(vetor, inicio, fim);
			quickSort(vetor, inicio, pivoIndex - 1);
			quickSort(vetor, pivoIndex + 1, fim);
		}
	}

	private static int partition(double[] vetor, int inicio, int fim) {
		double pivo = vetor[fim];
		int i = inicio - 1;

		for (int j = inicio; j < fim; j++) {
			if (vetor[j] <= pivo) {
				i++;
				trocar(vetor, i, j);
			}
		}
		trocar(vetor, i + 1, fim);
		return i + 1;
	}

	private static void trocar(double[] vetor, int i, int j) {
		double temp = vetor[i];
		vetor[i] = vetor[j];
		vetor[j] = temp;
	}

	// Implementação do algoritmo HeapSort
	public static void heapSort(double[] vetor) {
		int n = vetor.length;

		// Constrói o heap máximo
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(vetor, n, i);
		}

		// Extrai elementos do heap
		for (int i = n - 1; i > 0; i--) {
			trocar(vetor, 0, i);
			heapify(vetor, i, 0);
		}
	}

	private static void heapify(double[] vetor, int n, int i) {
		int maior = i;
		int esquerda = 2 * i + 1;
		int direita = 2 * i + 2;

		if (esquerda < n && vetor[esquerda] > vetor[maior]) {
			maior = esquerda;
		}

		if (direita < n && vetor[direita] > vetor[maior]) {
			maior = direita;
		}

		if (maior != i) {
			trocar(vetor, i, maior);
			heapify(vetor, n, maior);
		}
	}
}
