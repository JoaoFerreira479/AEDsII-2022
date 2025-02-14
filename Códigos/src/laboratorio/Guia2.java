package laboratorio;

import java.util.Arrays;

public class Guia2 {

	public static int produtoRecursivo(int a, int b) {
		if (b == 0) {
			return 0;
		}
		return a + produtoRecursivo(a, b - 1);
	}

	public static int somatorioRecursivo(int[] vetor, int tamanho) {
		validarVetor(vetor);
		if (tamanho == 0) {
			return 0;
		}
		return vetor[tamanho - 1] + somatorioRecursivo(vetor, tamanho - 1);
	}

	public static void exibirMatrizTransposta(int[][] matriz) {
		validarMatriz(matriz);

		int linhas = matriz.length;
		int colunas = matriz[0].length;
		int[][] transposta = new int[colunas][linhas];

		for (int i = 0; i < linhas; i++) {
			for (int j = 0; j < colunas; j++) {
				transposta[j][i] = matriz[i][j];
			}
		}

		System.out.println("Matriz transposta:");
		for (int[] linha : transposta) {
			System.out.println(Arrays.toString(linha));
		}
	}

	private static void validarVetor(int[] vetor) {
		if (vetor == null || vetor.length == 0) {
			throw new IllegalArgumentException("Vetor inválido: nulo ou vazio.");
		}
	}

	private static void validarMatriz(int[][] matriz) {
		if (matriz == null || matriz.length == 0) {
			throw new IllegalArgumentException("Matriz inválida: nula ou vazia.");
		}
	}

	public static void main(String[] args) {
		try {
			executarExemploProdutoRecursivo();
			executarExemploSomatorioRecursivo();
			executarExemploMatrizTransposta();
		} catch (IllegalArgumentException e) {
			System.err.println("Erro: " + e.getMessage());
		}
	}

	private static void executarExemploProdutoRecursivo() {
		int a = 5;
		int b = 3;
		System.out.println("Produto de " + a + " e " + b + ": " + produtoRecursivo(a, b));
	}

	private static void executarExemploSomatorioRecursivo() {
		int[] vetor = { 1, 2, 3, 4, 5 };
		System.out.println("Somatório do vetor: " + somatorioRecursivo(vetor, vetor.length));
	}

	private static void executarExemploMatrizTransposta() {
		int[][] matriz = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		exibirMatrizTransposta(matriz);
	}
}
