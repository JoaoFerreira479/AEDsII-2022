//RECURSIVIDADE

package nivelamento;

import java.util.Scanner;

public class SerieRecursiva {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			int n = lerValorInteiro(scanner, "Digite o valor de N (inteiro positivo): ");

			double resultado = calcularSerie(n);

			System.out.printf("O valor da série S para N = %d é: %.4f%n", n, resultado);

		} catch (Exception e) {
			System.err.println("Erro: Entrada inválida. Certifique-se de digitar um número inteiro positivo.");
		} finally {
			scanner.close();
		}
	}

	public static double calcularSerie(int n) {
		return calcularSerieAuxiliar(n, 1);
	}

	private static double calcularSerieAuxiliar(int n, int atual) {
		if (atual > n) {
			return 0;
		}

		double termo = (atual % 2 == 0) ? -1.0 / atual : 1.0 / atual;

		return termo + calcularSerieAuxiliar(n, atual + 1);
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
