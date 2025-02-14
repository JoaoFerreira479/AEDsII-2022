//RECURSIVIDADE

package nivelamento;

import java.util.Scanner;

public class IndicesParesRecursivo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			int n = lerTamanhoVetor(scanner);

			int[] vetor = lerVetor(scanner, n);

			System.out.println("Vetor completo:");
			exibirVetor(vetor);

			System.out.println("Valores nos índices pares do vetor:");
			imprimirIndicesPares(vetor, 0);

		} catch (IllegalArgumentException e) {
			System.err.println("Erro: " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Erro inesperado: Entrada inválida.");
		} finally {
			scanner.close();
		}
	}

	private static int lerTamanhoVetor(Scanner scanner) {
		while (true) {
			try {
				System.out.print("Digite o tamanho do vetor (N): ");
				int tamanho = scanner.nextInt();
				if (tamanho <= 0) {
					throw new IllegalArgumentException("O tamanho do vetor deve ser maior que zero.");
				}
				return tamanho;
			} catch (Exception e) {
				System.out.println("Erro: Entrada inválida. Certifique-se de digitar um número inteiro válido.");
				scanner.nextLine();
			}
		}
	}

	private static int[] lerVetor(Scanner scanner, int tamanho) {
		int[] vetor = new int[tamanho];
		System.out.println("Digite os elementos do vetor:");
		for (int i = 0; i < tamanho; i++) {
			vetor[i] = lerElemento(scanner, i);
		}
		return vetor;
	}

	private static int lerElemento(Scanner scanner, int indice) {
		while (true) {
			try {
				System.out.printf("Elemento %d: ", indice + 1);
				return scanner.nextInt();
			} catch (Exception e) {
				System.out.println("Erro: Entrada inválida. Certifique-se de digitar um número inteiro válido.");
				scanner.nextLine();
			}
		}
	}

	public static void imprimirIndicesPares(int[] vetor, int indice) {
		if (indice >= vetor.length) {
			return;
		}

		if (indice % 2 == 0) {
			System.out.printf("Índice %d: %d%n", indice, vetor[indice]);
		}

		imprimirIndicesPares(vetor, indice + 1);
	}

	private static void exibirVetor(int[] vetor) {
		for (int valor : vetor) {
			System.out.print(valor + " ");
		}
		System.out.println();
	}
}
