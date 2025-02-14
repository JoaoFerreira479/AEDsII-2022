//ESTRUTURAS CONDICIONAIS

package nivelamento;

import java.util.Scanner;

public class AvaliacaoNota {

	private static final double NOTA_MAXIMA = 10.0;
	private static final double NOTA_MINIMA = 0.0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			double nota = lerNota(scanner);

			String classificacao = classificarNota(nota);
			System.out.printf("A classificação da nota %.1f é: %s%n", nota, classificacao);

		} catch (IllegalArgumentException e) {
			System.err.println("Erro: " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Erro: Entrada inválida. Certifique-se de digitar um número decimal válido.");
		} finally {
			scanner.close();
		}
	}

	private static double lerNota(Scanner scanner) {
		while (true) {
			try {
				System.out.print("Digite a nota (entre 0 e 10): ");
				double nota = scanner.nextDouble();

				if (nota < NOTA_MINIMA || nota > NOTA_MAXIMA) {
					throw new IllegalArgumentException(
							"Nota inválida! Certifique-se de digitar uma nota entre 0 e 10.");
				}

				return nota;
			} catch (Exception e) {
				System.out.println("Erro: Entrada inválida. Digite um número decimal válido.");
				scanner.nextLine();
			}
		}
	}

	private static String classificarNota(double nota) {
		if (nota >= 8.0) {
			return "Ótimo";
		} else if (nota >= 7.0) {
			return "Bom";
		} else if (nota >= 5.0) {
			return "Regular";
		} else {
			return "Insatisfatório";
		}
	}
}
