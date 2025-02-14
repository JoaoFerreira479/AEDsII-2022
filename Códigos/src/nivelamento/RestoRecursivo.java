//RECURSIVIDADE

package nivelamento;

import java.util.Scanner;

public class RestoRecursivo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			int numerador = lerNumero(scanner, "Digite o numerador: ");
			int denominador = lerNumero(scanner, "Digite o denominador (deve ser maior que zero): ");

			if (!validarDenominador(denominador)) {
				System.out.println("Erro: O denominador deve ser maior que zero.");
				return;
			}

			int resto = calcularResto(Math.abs(numerador), Math.abs(denominador));

			if (numerador < 0) {
				resto = -resto;
			}

			System.out.println("O resto da divisão de " + numerador + " por " + denominador + " é: " + resto);

		} catch (Exception e) {
			System.err.println("Erro: Entrada inválida. Certifique-se de digitar números inteiros.");
		} finally {
			scanner.close();
		}
	}

	public static int calcularResto(int numerador, int denominador) {
		if (numerador < denominador) {
			return numerador;
		}
		return calcularResto(numerador - denominador, denominador);
	}

	public static boolean validarDenominador(int denominador) {
		return denominador > 0;
	}

	public static int lerNumero(Scanner scanner, String mensagem) {
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
