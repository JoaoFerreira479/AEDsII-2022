package laboratorio;

import java.util.Arrays;

public class Guia1 {

	public static int[] gerarFibonacci(int quantidade) {
		if (quantidade <= 0) {
			throw new IllegalArgumentException("A quantidade deve ser maior que 0");
		}

		int[] serieFibonacci = new int[quantidade];

		if (quantidade >= 1) {
			serieFibonacci[0] = 0;
		}
		if (quantidade >= 2) {
			serieFibonacci[1] = 1;
		}

		for (int i = 2; i < quantidade; i++) {
			serieFibonacci[i] = serieFibonacci[i - 1] + serieFibonacci[i - 2];
		}

		return serieFibonacci;
	}

	public static int somaDosTermos(int[] numeros, int n) {
		validarVetor(numeros);
		if (n <= 0 || n > numeros.length) {
			throw new IllegalArgumentException("Quantidade de termos inválida: " + n);
		}

		return Arrays.stream(numeros).limit(n).sum();
	}

	public static int[] obterDivisiveisPor(int[] numeros, int divisor) {
		validarVetor(numeros);
		if (divisor == 0) {
			throw new IllegalArgumentException("O divisor não pode ser zero");
		}

		return Arrays.stream(numeros).filter(num -> num % divisor == 0).toArray();
	}

	private static void validarVetor(int[] numeros) {
		if (numeros == null || numeros.length == 0) {
			throw new IllegalArgumentException("Vetor inválido: nulo ou vazio");
		}
	}

	public static void main(String[] args) {
		try {
			executarExemploFibonacci();
			executarExemploSomaDosTermos();
			executarExemploDivisiveisPor();
		} catch (IllegalArgumentException e) {
			System.err.println("Erro: " + e.getMessage());
		}
	}

	private static void executarExemploFibonacci() {
		int quantidade = 10;
		int[] fibonacci = gerarFibonacci(quantidade);
		System.out.println("Série de Fibonacci: " + Arrays.toString(fibonacci));
	}

	private static void executarExemploSomaDosTermos() {
		int[] vetorExemplo = { 1, 3, 5, 7, 9, 11 };
		int soma = somaDosTermos(vetorExemplo, 4);
		System.out.println("Soma dos primeiros 4 números: " + soma);
	}

	private static void executarExemploDivisiveisPor() {
		int[] vetorDivisiveis = { 10, 15, 22, 33, 40 };
		int divisor = 10;
		int[] divisiveisPor10 = obterDivisiveisPor(vetorDivisiveis, divisor);
		System.out.println("Números divisíveis por " + divisor + ": " + Arrays.toString(divisiveisPor10));
	}
}
