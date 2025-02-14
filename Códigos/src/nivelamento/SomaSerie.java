//REPETIÇÃO

package nivelamento;

import java.util.Scanner;

public class SomaSerie {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			int n = lerValorInteiro(scanner, "Digite um número inteiro e positivo (n): ");

			double soma = calcularSomaSerie(n);

			System.out.printf("Valor final de S: %.4f%n", soma);

		} catch (Exception e) {
			System.err.println("Erro: " + e.getMessage());
		} finally {
			scanner.close();
		}
	}

	private static int lerValorInteiro(Scanner scanner, String mensagem) {
		int valor;
		while (true) {
			try {
				System.out.print(mensagem);
				valor = scanner.nextInt();
				if (valor > 0) {
					return valor;
				} else {
					System.out.println("Erro: O número deve ser maior que zero.");
				}
			} catch (Exception e) {
				System.out.println("Erro: Entrada inválida. Digite um número inteiro válido.");
				scanner.nextLine();
			}
		}
	}

	private static double calcularSomaSerie(int n) {
		double soma = 0.0;
		System.out.println("Termos gerados:");
		for (int i = 1; i <= n; i++) {
			double termo = 1.0 / i;
			soma += termo;
			System.out.printf("1/%d = %.4f%n", i, termo);
		}
		return soma;
	}
}
