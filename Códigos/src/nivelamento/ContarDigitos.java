//RECURSIVIDADE

package nivelamento;

import java.util.Scanner;

public class ContarDigitos {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			int numero = lerNumero(scanner);

			int quantidadeDigitos = contarDigitos(Math.abs(numero));

			System.out.printf("O número %d possui %d dígito(s).%n", numero, quantidadeDigitos);

		} catch (IllegalArgumentException e) {
			System.err.println("Erro: " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Erro inesperado: Entrada inválida.");
		} finally {
			scanner.close();
		}
	}

	private static int lerNumero(Scanner scanner) {
		while (true) {
			try {
				System.out.print("Digite um número inteiro: ");
				return scanner.nextInt();
			} catch (Exception e) {
				System.out.println("Erro: Entrada inválida. Certifique-se de digitar um número inteiro.");
				scanner.nextLine();
			}
		}
	}

	public static int contarDigitos(int numero) {
		if (numero == 0) {
			return 1;
		}

		if (numero < 10) {
			return 1;
		}

		return 1 + contarDigitos(numero / 10);
	}
}
