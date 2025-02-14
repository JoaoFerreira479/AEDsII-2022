package lista2treino;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SomatoriosNovo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int opcao;

		do {
			exibirMenu();
			opcao = lerOpcao(scanner);

			switch (opcao) {
			case 1 -> calcularSomatorioPotencia(1, 5, 3);
			case 2 -> calcularSomatorioBasePotencia(1, 6, 3);
			case 3 -> calcularSomatorioXPotencia(scanner);
			case 4 -> calcularSomatorioAlternado(1, 6, 3);
			case 5 -> calcularSomatorioFracoesAlternado(1, 3);
			case 0 -> System.out.println("Programa encerrado.");
			default -> System.out.println("Opção inválida. Tente novamente.");
			}

		} while (opcao != 0);

		scanner.close();
	}

	private static void exibirMenu() {
		System.out.println("\n=== Calculadora de Somatórios ===");
		System.out.println("1) ∑ n=1 até 5 de n^3");
		System.out.println("2) ∑ n=1 até 6 de 3^n");
		System.out.println("3) ∑ i=1 até N de x_i^3");
		System.out.println("4) ∑ n=1 até 6 de (-1)^n * n^3");
		System.out.println("5) ∑ i=1 até 3 de (-1)^(i+1) / (2i+1)");
		System.out.println("0) Sair");
		System.out.print("\nOpção: ");
	}

	private static int lerOpcao(Scanner scanner) {
		while (true) {
			try {
				return scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Erro: Entrada inválida. Digite um número inteiro.");
				scanner.nextLine(); 
				System.out.print("Opção: ");
			}
		}
	}

	private static void calcularSomatorioPotencia(int inicio, int fim, int potencia) {
		int soma = 0;
		StringBuilder passos = new StringBuilder();

		for (int n = inicio; n <= fim; n++) {
			int termo = (int) Math.pow(n, potencia);
			passos.append(termo).append(n < fim ? " + " : "");
			soma += termo;
		}

		exibirResultado("∑ n=" + inicio + " até " + fim + " de n^" + potencia, passos.toString(), soma);
	}

	private static void calcularSomatorioBasePotencia(int inicio, int fim, int base) {
		int soma = 0;
		StringBuilder passos = new StringBuilder();

		for (int n = inicio; n <= fim; n++) {
			int termo = (int) Math.pow(base, n);
			passos.append(termo).append(n < fim ? " + " : "");
			soma += termo;
		}

		exibirResultado("∑ n=" + inicio + " até " + fim + " de " + base + "^n", passos.toString(), soma);
	}

	private static void calcularSomatorioXPotencia(Scanner scanner) {
		System.out.print("\nDigite o valor de N: ");
		int N = lerOpcao(scanner);
		int soma = 0;
		StringBuilder passos = new StringBuilder();

		for (int i = 1; i <= N; i++) {
			System.out.print("Digite o valor de x_" + i + ": ");
			int x = lerOpcao(scanner);
			int termo = (int) Math.pow(x, 3);
			passos.append(termo).append(i < N ? " + " : "");
			soma += termo;
		}

		exibirResultado("∑ i=1 até " + N + " de x_i^3", passos.toString(), soma);
	}

	private static void calcularSomatorioAlternado(int inicio, int fim, int potencia) {
		int soma = 0;
		StringBuilder passos = new StringBuilder();

		for (int n = inicio; n <= fim; n++) {
			int sinal = (int) Math.pow(-1, n);
			int termo = sinal * (int) Math.pow(n, potencia);
			passos.append(termo).append(n < fim ? " + " : "");
			soma += termo;
		}

		exibirResultado("∑ n=" + inicio + " até " + fim + " de (-1)^n * n^" + potencia, passos.toString(), soma);
	}

	private static void calcularSomatorioFracoesAlternado(int inicio, int fim) {
		Fracao soma = new Fracao(0, 1);
		StringBuilder passos = new StringBuilder();

		for (int i = inicio; i <= fim; i++) {
			int sinal = (int) Math.pow(-1, i + 1);
			Fracao termo = new Fracao(sinal, 2 * i + 1);
			passos.append(termo).append(i < fim ? " + " : "");
			soma = soma.adicionar(termo);
		}

		exibirResultado("∑ i=" + inicio + " até " + fim + " de (-1)^(i+1) / (2i+1)", passos.toString(), soma);
	}

	private static void exibirResultado(String descricao, String passos, Object soma) {
		System.out.println("\nResultado de " + descricao + ":");
		System.out.println(passos + " = " + soma);
	}
}

class Fracao {
	private final int numerador;
	private final int denominador;

	public Fracao(int numerador, int denominador) {
		if (denominador == 0) {
			throw new ArithmeticException("Denominador não pode ser zero.");
		}
		int mdc = calcularMDC(Math.abs(numerador), Math.abs(denominador));
		this.numerador = ajustarSinal(numerador / mdc, denominador);
		this.denominador = Math.abs(denominador / mdc);
	}

	private int ajustarSinal(int numerador, int denominador) {
		return denominador < 0 ? -numerador : numerador;
	}

	public Fracao adicionar(Fracao outra) {
		int novoNumerador = this.numerador * outra.denominador + outra.numerador * this.denominador;
		int novoDenominador = this.denominador * outra.denominador;
		return new Fracao(novoNumerador, novoDenominador);
	}

	@Override
	public String toString() {
		return denominador == 1 ? String.valueOf(numerador) : numerador + "/" + denominador;
	}

	private int calcularMDC(int a, int b) {
		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
}
