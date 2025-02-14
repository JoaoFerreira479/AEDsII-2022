//RECURSIVIDADE

package nivelamento;

import java.util.Scanner;

public class SomaRecursivaVetor {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			int n = lerValorInteiro(scanner, "Digite o tamanho do vetor (N): ");

			int[] vetor = new int[n];
			System.out.println("Digite os elementos do vetor:");
			preencherVetor(scanner, vetor);

			int soma = calcularSoma(vetor, vetor.length - 1);

			System.out.println("A soma dos elementos do vetor é: " + soma);

		} catch (Exception e) {
			System.err.println("Erro: Entrada inválida. Certifique-se de digitar números inteiros.");
		} finally {
			scanner.close();
		}
	}

	public static int calcularSoma(int[] vetor, int indice) {
		if (indice < 0) {
			return 0;
		}
		return vetor[indice] + calcularSoma(vetor, indice - 1);
	}

	private static void preencherVetor(Scanner scanner, int[] vetor) {
		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = lerValorInteiro(scanner, String.format("Elemento %d: ", i + 1));
		}
	}

	private static int lerValorInteiro(Scanner scanner, String mensagem) {
		while (true) {
			try {
				System.out.print(mensagem);
				return scanner.nextInt();
			} catch (Exception e) {
				System.out.println("Erro: Entrada inválida. Digite um número inteiro válido.");
				scanner.nextLine();
			}
		}
	}
}
