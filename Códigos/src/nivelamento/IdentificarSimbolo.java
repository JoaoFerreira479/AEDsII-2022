//ESTRUTURAS CONDICIONAIS

package nivelamento;

import java.util.Scanner;

public class IdentificarSimbolo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			char simbolo = lerSimbolo(scanner);

			String tipoSimbolo = identificarSimbolo(simbolo);
			System.out.println(tipoSimbolo);

		} catch (IllegalArgumentException e) {
			System.err.println("Erro: " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Erro inesperado: Entrada inválida.");
		} finally {
			scanner.close();
		}
	}

	private static char lerSimbolo(Scanner scanner) {
		System.out.print("Digite um símbolo: ");
		String entrada = scanner.next();

		if (entrada.length() != 1) {
			throw new IllegalArgumentException("A entrada deve ser um único caractere.");
		}

		return entrada.charAt(0);
	}

	private static String identificarSimbolo(char simbolo) {
		switch (simbolo) {
		case '>':
			return "Sinal de maior.";
		case '<':
			return "Sinal de menor.";
		case '=':
			return "Sinal de igual.";
		default:
			return "Outro sinal.";
		}
	}
}
