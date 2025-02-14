package lista1treino;

public class ExerciciosPotLogFpFtCompleto {

	public static void main(String[] args) {
		System.out.println("Exercícios - potências, logaritmos, função piso e função teto\n");

		// Resultados
		exibirPotencias();
		exibirLogaritmos();
		exibirPisoETeto();
	}

	// Método para calcular e exibir potências
	private static void exibirPotencias() {
		System.out.println("Potências:");
		double[][] valores = { { 2, 3 }, { 2, 10 }, { 2, 20 }, { 4, 2 }, { 4, 3 }, { 4, 4 }, { 2, 5 } };
		for (int i = 0; i < valores.length; i++) {
			double base = valores[i][0];
			double expoente = valores[i][1];
			System.out.printf("%d) %.0f^%.0f = %.0f%n", i + 1, base, expoente, Math.pow(base, expoente));
		}
		System.out.println();
	}

	// Método para calcular e exibir logaritmos
	private static void exibirLogaritmos() {
		System.out.println("Logaritmos:");
		double[] valores = { 256, 1024, 60, 2024, 2048, 32, 15 };
		for (int i = 0; i < valores.length; i++) {
			System.out.printf("%d) log(%.0f) = %.5f%n", i + 8, valores[i], Math.log10(valores[i]));
		}
		System.out.println();
	}

	// Método para calcular e exibir funções piso e teto
	private static void exibirPisoETeto() {
		System.out.println("Funções Piso e Teto:");

		double[] valoresLog = { 200, 60 };
		for (int i = 0; i < valoresLog.length; i++) {
			double log = Math.log10(valoresLog[i]);
			System.out.printf("%d) log(%.0f): ⌊log(x)⌋ = %.0f, ⌈log(x)⌉ = %.0f%n", i + 15, valoresLog[i],
					Math.floor(log), Math.ceil(log));
		}

		double[] valores = { 2.34, 18.2 };
		for (int i = 0; i < valores.length; i++) {
			System.out.printf("%d) %.2f: ⌊x⌋ = %.0f, ⌈x⌉ = %.0f%n", i + 18, valores[i], Math.floor(valores[i]),
					Math.ceil(valores[i]));
		}

		System.out.println();
	}
}
