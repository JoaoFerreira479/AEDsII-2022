//REPETIÇÃO

package nivelamento;

import java.util.Random;

public class ParOuImpar {

	public static void main(String[] args) {
		int quantidadeNumeros = 10;
		int limiteSuperior = 100;

		Random gerador = new Random();

		System.out.println("Gerando números aleatórios e verificando se são PAR ou ÍMPAR:");

		for (int i = 0; i < quantidadeNumeros; i++) {
			int numero = gerarNumeroAleatorio(gerador, limiteSuperior);
			verificarParOuImpar(numero);
		}
	}

	private static int gerarNumeroAleatorio(Random gerador, int limiteSuperior) {
		return gerador.nextInt(limiteSuperior);
	}

	private static void verificarParOuImpar(int numero) {
		if (numero % 2 == 0) {
			System.out.println("Número " + numero + " é PAR.");
		} else {
			System.out.println("Número " + numero + " é ÍMPAR.");
		}
	}
}
