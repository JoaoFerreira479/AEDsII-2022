package lista1treino;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ContadorDeOperacoesDinamicoNovo {

	public static void main(String[] args) {
		System.out.println("=== Sistema de Análise de Operações em Códigos Java ===\n");
		System.out.println(
				"Cole o código Java que deseja analisar e pressione ENTER duas vezes ou escreva FIM para finalizar a entrada:\n");

		Scanner scanner = new Scanner(System.in);
		StringBuilder codigo = new StringBuilder();

		try {
			capturarCodigo(scanner, codigo);

			String codigoLimpo = removerNumerosDeLinha(codigo.toString());

			if (!validarCodigoJava(codigoLimpo)) {
				System.out.println("Erro: O código fornecido não é reconhecido como válido para a linguagem Java.");
				return;
			}

			OperacoesAnalise analise = new OperacoesAnalise();
			analise.analisar(codigoLimpo);

		} catch (Exception e) {
			System.err.println("Erro ao processar o código: " + e.getMessage());
		} finally {
			scanner.close();
		}
	}

	private static void capturarCodigo(Scanner scanner, StringBuilder codigo) {
		String linha;
		boolean entradaVazia = false;

		while (scanner.hasNextLine()) {
			linha = scanner.nextLine();
			if (linha.trim().equalsIgnoreCase("FIM")) {
				break;
			}
			if (linha.trim().isEmpty()) {
				if (entradaVazia) {
					break;
				}
				entradaVazia = true;
			} else {
				entradaVazia = false;
			}
			codigo.append(linha).append("\n");
		}

		if (codigo.toString().trim().isEmpty()) {
			System.out.println("Nenhum código foi fornecido. Finalizando o programa.");
			System.exit(0);
		}
	}

	private static String removerNumerosDeLinha(String codigo) {
		StringBuilder codigoLimpo = new StringBuilder();
		String[] linhas = codigo.split("\n");
		for (String linha : linhas) {
			String linhaSemNumero = linha.replaceFirst("^\\s*\\d+\\s+", "");
			codigoLimpo.append(linhaSemNumero).append("\n");
		}
		return codigoLimpo.toString();
	}

	private static boolean validarCodigoJava(String codigo) {
		String[] padroesJava = { "class\\s+\\w+", // Declaração de classe
				"public\\s+(static\\s+)?void\\s+main\\s*\\(", // Método main
				"System\\.out\\.println\\(.*\\);" // Impressão no console
		};
		for (String padrao : padroesJava) {
			if (codigo.matches("(?s).*" + padrao + ".*")) {
				return true;
			}
		}
		return false;
	}
}

// Outras classes
class OperacoesAnalise {

	private final Map<String, String> operacoes;

	public OperacoesAnalise() {
		operacoes = new LinkedHashMap<>();
		inicializarOperacoes();
	}

	private void inicializarOperacoes() {

		// Operações aritméticas
		operacoes.put("\\+", "Adições (+)");
		operacoes.put("-", "Subtrações (-)");
		operacoes.put("\\*", "Multiplicações (*)");
		operacoes.put("/", "Divisões (/)");
		operacoes.put("%", "Módulos (%)");

		// Operações de comparação
		operacoes.put("==", "Comparações de igualdade (==)");
		operacoes.put("!=", "Comparações de diferença (!=)");
		operacoes.put("<", "Comparações menor (<)");
		operacoes.put("<=", "Comparações menor ou igual (<=)");
		operacoes.put(">", "Comparações maior (>)");
		operacoes.put(">=", "Comparações maior ou igual (>=)");

		// Operações lógicas
		operacoes.put("&&", "Operações AND (&&)");
		operacoes.put("\\|\\|", "Operações OR (||)");
		operacoes.put("!", "Operações NOT (!)");

		// Controle de fluxo
		operacoes.put("if\\s*\\(.*\\)", "Estruturas if");
		operacoes.put("for\\s*\\(.*\\)", "Loops for");
		operacoes.put("while\\s*\\(.*\\)", "Loops while");
		operacoes.put("do\\s*\\{", "Loops do-while");
		operacoes.put("switch\\s*\\(.*\\)", "Estruturas switch");
	}

	public void analisar(String codigo) {
		System.out.println("\n=== Resultado da Análise ===");

		for (Map.Entry<String, String> operacao : operacoes.entrySet()) {
			int count = contarOcorrencias(codigo, operacao.getKey());
			System.out.printf("%s: %d\n", operacao.getValue(), count);
		}
	}

	private int contarOcorrencias(String texto, String regex) {
		return texto.split(regex).length - 1;
	}
}
