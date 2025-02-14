//VETORES E MATRIZES

package nivelamento;

import java.util.Scanner;

public class SomaDiagonalPrincipal {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			int n = lerValorInteiro(scanner, "Digite a dimensão da matriz quadrada (N x N): ");

			int[][] matriz = preencherMatriz(scanner, n);

			int somaDiagonal = calcularSomaDiagonalPrincipal(matriz);

			System.out.println("A soma da diagonal principal é: " + somaDiagonal);

		} catch (Exception e) {
			System.err.println("Erro: " + e.getMessage());
		} finally {
			scanner.close();
		}
	}

	private static int calcularSomaDiagonalPrincipal(int[][] matriz) {
		int soma = 0;
		for (int i = 0; i < matriz.length; i++) {
			soma += matriz[i][i];
		}
		return soma;
	}

	private static int[][] preencherMatriz(Scanner scanner, int tamanho) {
		int[][] matriz = new int[tamanho][tamanho];
		System.out.println("Digite os elementos da matriz:");

		for (int i = 0; i < tamanho; i++) {
			for (int j = 0; j < tamanho; j++) {
				matriz[i][j] = lerValorInteiro(scanner, String.format("Elemento [%d][%d]: ", i, j));
			}
		}

		return matriz;
	}

	private static int lerValorInteiro(Scanner scanner, String mensagem) {
		while (true) {
			try {
				System.out.print(mensagem);
				int valor = scanner.nextInt();
				if (valor > 0) {
					return valor;
				} else {
					System.out.println("Erro: O valor deve ser maior que zero.");
				}
			} catch (Exception e) {
				System.out.println("Erro: Entrada inválida. Digite um número inteiro positivo.");
				scanner.nextLine();
			}
		}
	}
}
