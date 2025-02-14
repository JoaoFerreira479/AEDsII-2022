//ESTRUTURAS CONDICIONAIS

package nivelamento;

import java.util.Scanner;
import java.util.Arrays;

public class OrdenarTresNumeros {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			int[] numeros = new int[3];
			for (int i = 0; i < numeros.length; i++) {
				numeros[i] = lerNumero(scanner, "Digite o " + (i + 1) + "º número: ");
			}

			Arrays.sort(numeros);

			System.out.println("Os números em ordem crescente são:");
			System.out.println(Arrays.toString(numeros));

		} catch (Exception e) {
			System.err.println("Erro: Entrada inválida. Certifique-se de digitar números inteiros.");
		} finally {
			scanner.close();
		}
	}

	private static int lerNumero(Scanner scanner, String mensagem) {
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
