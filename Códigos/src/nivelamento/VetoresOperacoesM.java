//MODULARIZAÇÃO

package nivelamento;

import java.util.Scanner;

public class VetoresOperacoesM {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			int tamanho = lerTamanhoVetor(scanner, "Digite o tamanho dos vetores: ");
			int[] X = new int[tamanho];
			int[] Y = new int[tamanho];

			System.out.println("Preenchendo o vetor X:");
			preencherVetor(scanner, X);
			System.out.println("Preenchendo o vetor Y:");
			preencherVetor(scanner, Y);

			System.out.println("\nCalculando a soma dos vetores X e Y:");
			calcularESomarVetores(X, Y);

			System.out.println("\nCalculando o produto dos vetores X e Y:");
			calcularEProdutoVetores(X, Y);

		} catch (Exception e) {
			System.err.println("Erro: Entrada inválida. Certifique-se de digitar números inteiros.");
		} finally {
			scanner.close();
		}
	}

	private static int lerTamanhoVetor(Scanner scanner, String mensagem) {
		int tamanho;
		while (true) {
			try {
				System.out.print(mensagem);
				tamanho = scanner.nextInt();
				if (tamanho <= 0) {
					System.out.println("O tamanho do vetor deve ser maior que zero.");
				} else {
					break;
				}
			} catch (Exception e) {
				System.out.println("Erro: Entrada inválida. Digite um número inteiro válido.");
				scanner.nextLine();
			}
		}
		return tamanho;
	}

	public static void preencherVetor(Scanner scanner, int[] vetor) {
		for (int i = 0; i < vetor.length; i++) {
			System.out.print("Digite o elemento " + (i + 1) + ": ");
			vetor[i] = scanner.nextInt();
		}
	}

	public static void calcularESomarVetores(int[] X, int[] Y) {
		int[] soma = new int[X.length];
		for (int i = 0; i < X.length; i++) {
			soma[i] = X[i] + Y[i];
		}

		System.out.println("Vetor Soma: " + vetorParaString(soma));
	}

	public static void calcularEProdutoVetores(int[] X, int[] Y) {
		int[] produto = new int[X.length];
		for (int i = 0; i < X.length; i++) {
			produto[i] = X[i] * Y[i];
		}

		System.out.println("Vetor Produto: " + vetorParaString(produto));
	}

	public static String vetorParaString(int[] vetor) {
		StringBuilder sb = new StringBuilder();
		for (int valor : vetor) {
			sb.append(valor).append(" ");
		}
		return sb.toString().trim();
	}
}
