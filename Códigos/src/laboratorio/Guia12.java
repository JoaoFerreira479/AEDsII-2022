package laboratorio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Guia12 {

	public static void adicionarNomes(List<String> lista, Scanner scanner) {
		System.out.println("Digite os nomes para adicionar na lista (ou 'STOP' para encerrar):");
		while (true) {
			String nome = scanner.nextLine().trim();
			if (nome.equalsIgnoreCase("STOP")) {
				break;
			}
			lista.add(nome);
			System.out.println("Nome adicionado: " + nome);
		}
		Collections.sort(lista); // Mantém a lista ordenada
		System.out.println("Lista atualizada e ordenada.");
	}

	// Imprime todos os elementos da lista com suas respectivas posições
	public static void imprimirLista(List<String> lista) {
		if (lista.isEmpty()) {
			System.out.println("A lista está vazia.");
			return;
		}
		System.out.println("Elementos da lista:");
		for (int i = 0; i < lista.size(); i++) {
			System.out.println("Posição " + i + ": " + lista.get(i));
		}
	}

	// Realiza uma busca sequencial para verificar se o nome está na lista
	public static boolean buscaSequencial(List<String> lista, String nome) {
		return lista.contains(nome);
	}

	// Realiza uma busca binária para verificar se o nome está na lista
	public static boolean buscaBinaria(List<String> lista, String nome) {
		// A lista deve estar ordenada
		int index = Collections.binarySearch(lista, nome);
		return index >= 0;
	}

	// Remove a primeira ocorrência de um nome na lista
	public static void removerNome(List<String> lista, String nome) {
		int index = Collections.binarySearch(lista, nome);
		if (index >= 0) {
			lista.remove(index);
			System.out.println("Nome \"" + nome + "\" removido da lista.");
		} else {
			System.out.println("Nome \"" + nome + "\" não encontrado na lista.");
		}
	}

	// Adiciona um nome em uma posição específica na lista
	public static void adicionarNaPosicao(List<String> lista, String nome, int posicao) {
		if (posicao < 0 || posicao > lista.size()) {
			System.out.println("Posição inválida! Nenhuma alteração foi feita.");
			return;
		}
		lista.add(posicao, nome);
		Collections.sort(lista); // Mantém a lista ordenada após a adição
		System.out.println("Nome \"" + nome + "\" adicionado e lista reordenada.");
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> lista = new ArrayList<>();

		// Adiciona nomes à lista
		adicionarNomes(lista, scanner);

		// Imprime os elementos da lista
		imprimirLista(lista);

		// Realiza uma busca sequencial
		System.out.println("\nDigite um nome para buscar na lista (sequencial):");
		String buscaSeqNome = scanner.nextLine().trim();
		boolean encontradoSeq = buscaSequencial(lista, buscaSeqNome);
		System.out.println("Nome encontrado (sequencial)? " + encontradoSeq);

		// Realiza uma busca binária
		System.out.println("\nDigite um nome para buscar na lista (binária):");
		String buscaBinNome = scanner.nextLine().trim();
		boolean encontradoBin = buscaBinaria(lista, buscaBinNome);
		System.out.println("Nome encontrado (binária)? " + encontradoBin);

		// Remove um nome da lista
		System.out.println("\nDigite um nome para remover da lista:");
		String nomeRemover = scanner.nextLine().trim();
		removerNome(lista, nomeRemover);
		imprimirLista(lista);

		// Adiciona um nome em uma posição específica
		System.out.println("\nDigite um nome para adicionar:");
		String nomeAdicionar = scanner.nextLine().trim();
		System.out.println("Digite a posição onde deseja adicionar:");
		int posicao;
		try {
			posicao = Integer.parseInt(scanner.nextLine().trim());
			adicionarNaPosicao(lista, nomeAdicionar, posicao);
			imprimirLista(lista);
		} catch (NumberFormatException e) {
			System.out.println("Posição inválida! Digite um número inteiro.");
		}

		scanner.close();
	}
}
