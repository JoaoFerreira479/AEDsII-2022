//VETORES E MATRIZES

package nivelamento;

import java.util.Scanner;

public class CompararMatrizes {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			System.out.println("=== Primeira Matriz ===");
			int[][] matriz1 = lerMatriz(scanner);

			System.out.println("=== Segunda Matriz ===");
			int[][] matriz2 = lerMatriz(scanner);

			if (!validarDimensoes(matriz1, matriz2)) {
				System.out.println("As matrizes têm tamanhos diferentes e, portanto, não são iguais.");
			} else {
				boolean saoIguais = compararMatrizes(matriz1, matriz2);
				System.out.println(saoIguais ? "As matrizes são iguais." : "As matrizes não são iguais.");
			}

		} catch (IllegalArgumentException e) {
			System.err.println("Erro: " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Erro inesperado: " + e.getMessage());
		} finally {
			scanner.close();
		}
	}

	private static int[][] lerMatriz(Scanner scanner) {
		int linhas = lerValorInteiro(scanner, "Digite o número de linhas: ", 1);
		int colunas = lerValorInteiro(scanner, "Digite o número de colunas: ", 1);

		int[][] matriz = new int[linhas][colunas];
		System.out.println("Preenchendo a matriz:");
		for (int i = 0; i < linhas; i++) {
			for (int j = 0; j < colunas; j++) {
				matriz[i][j] = lerValorInteiro(scanner, String.format("Elemento [%d][%d]: ", i, j));
			}
		}
		return matriz;
	}

	private static boolean validarDimensoes(int[][] matriz1, int[][] matriz2) {
		return matriz1.length == matriz2.length && matriz1[0].length == matriz2[0].length;
	}

	private static boolean compararMatrizes(int[][] matriz1, int[][] matriz2) {
		for (int i = 0; i < matriz1.length; i++) {
			for (int j = 0; j < matriz1[i].length; j++) {
				if (matriz1[i][j] != matriz2[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	private static int lerValorInteiro(Scanner scanner, String mensagem) {
		return lerValorInteiro(scanner, mensagem, Integer.MIN_VALUE);
	}

	private static int lerValorInteiro(Scanner scanner, String mensagem, int limiteMinimo) {
		while (true) {
			try {
				System.out.print(mensagem);
				int valor = scanner.nextInt();
				if (valor < limiteMinimo) {
					throw new IllegalArgumentException("O valor deve ser maior ou igual a " + limiteMinimo + ".");
				}
				return valor;
			} catch (Exception e) {
				System.out.println("Erro: Entrada inválida. Digite um número inteiro válido.");
				scanner.nextLine();
			}
		}
	}
}
