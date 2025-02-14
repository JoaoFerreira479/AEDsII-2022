//VETORES E MATRIZES

package nivelamento;

import java.util.Scanner;

public class RemoverElementoVetor {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			int n = lerValorInteiro(scanner, "Digite o tamanho do vetor (N): ");

			if (n <= 0) {
				System.out.println("O tamanho do vetor deve ser maior que zero.");
				return;
			}

			int[] vetor = new int[n];
			System.out.println("Digite os elementos do vetor:");

			for (int i = 0; i < n; i++) {
				vetor[i] = lerValorInteiro(scanner, "Elemento [" + i + "]: ");
			}

			while (true) {
				exibirVetor(vetor);

				int indice = lerValorInteiro(scanner,
						"Digite o índice do elemento a ser removido (-1 para encerrar): ");

				if (indice == -1) {
					System.out.println("Programa encerrado.");
					break;
				}

				if (indice < 0 || indice >= vetor.length || vetor[indice] == 0) {
					System.out.println("Índice inválido ou elemento já removido! Tente novamente.");
				} else {
					vetor = removerElemento(vetor, indice);
					System.out.println("Elemento removido com sucesso.");
				}

				if (vetor.length == 0) {
					System.out.println("Todos os elementos foram removidos. Encerrando o programa.");
					break;
				}
			}

		} catch (Exception e) {
			System.err.println("Erro: Entrada inválida. Certifique-se de digitar números inteiros.");
		} finally {
			scanner.close();
		}
	}

	private static void exibirVetor(int[] vetor) {
		System.out.print("Vetor atual: ");
		for (int valor : vetor) {
			System.out.print(valor + " ");
		}
		System.out.println();
	}

	private static int[] removerElemento(int[] vetor, int indice) {
		int[] novoVetor = new int[vetor.length - 1];
		for (int i = 0, j = 0; i < vetor.length; i++) {
			if (i != indice) {
				novoVetor[j++] = vetor[i];
			}
		}
		return novoVetor;
	}

	private static int lerValorInteiro(Scanner scanner, String mensagem) {
		int valor;
		while (true) {
			try {
				System.out.print(mensagem);
				valor = scanner.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("Erro: Entrada inválida. Digite um número inteiro válido.");
				scanner.nextLine();
			}
		}
		return valor;
	}
}
