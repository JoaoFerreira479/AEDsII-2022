package laboratorio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

// Classe No: representa um nó na árvore binária
class No {
	String nome; // Nome do contato
	String telefone; // Telefone do contato
	No esquerdo, direito; // Referências para os nós esquerdo e direito

	public No(String nome, String telefone) {
		this.nome = nome;
		this.telefone = telefone;
		this.esquerdo = null;
		this.direito = null;
	}
}

// Classe ArvoreBinaria: classe para representar uma árvore binária de busca
class ArvoreBinaria {
	private No raiz; // Raiz da árvore

	public ArvoreBinaria() {
		this.raiz = null;
	}

	public No getRaiz() {
		return this.raiz;
	}

	// Insere um contato na árvore
	public void inserir(String nome, String telefone) {
		No novo = new No(nome, telefone);
		if (raiz == null) { // Caso base: a árvore está vazia
			raiz = novo;
		} else {
			inserirRecursivo(raiz, novo); // Inserção recursiva
		}
	}

	// Função auxiliar para inserção recursiva
	private void inserirRecursivo(No atual, No novo) {
		if (novo.nome.compareToIgnoreCase(atual.nome) < 0) {
			if (atual.esquerdo == null) { // Inserir esquerda
				atual.esquerdo = novo;
			} else {
				inserirRecursivo(atual.esquerdo, novo);
			}
		} else { // Inserir direita
			if (atual.direito == null) {
				atual.direito = novo;
			} else {
				inserirRecursivo(atual.direito, novo);
			}
		}
	}

	// Busca um contato pelo nome
	public void buscar(String nome) {
		if (raiz == null) {
			System.out.println("A agenda está vazia.");
			return;
		}
		No resultado = buscarRecursivo(raiz, nome);
		if (resultado != null) {
			System.out.println("Telefone encontrado: " + resultado.telefone);
		} else {
			System.out.println("Nome não encontrado na agenda.");
		}
	}

	// Função auxiliar para busca recursiva
	private No buscarRecursivo(No atual, String nome) {
		if (atual == null || atual.nome.equalsIgnoreCase(nome)) {
			return atual; // Caso base: encontrado ou árvore vazia
		}
		if (nome.compareToIgnoreCase(atual.nome) < 0) {
			return buscarRecursivo(atual.esquerdo, nome); // Buscar esquerda
		}
		return buscarRecursivo(atual.direito, nome); // Buscar direita
	}

	// Lista os contatos em ordem alfabética
	public void listarEmOrdem() {
		if (raiz == null) {
			System.out.println("A agenda está vazia.");
			return;
		}
		listarRecursivo(raiz);
	}

	// Função auxiliar para percorrer a árvore em ordem
	private void listarRecursivo(No atual) {
		if (atual != null) {
			listarRecursivo(atual.esquerdo);
			System.out.println(atual.nome + " - " + atual.telefone);
			listarRecursivo(atual.direito);
		}
	}

	// Remove um contato pelo nome
	public void remover(String nome) {
		if (raiz == null) {
			System.out.println("A agenda está vazia. Não é possível remover contatos.");
			return;
		}
		raiz = removerRecursivo(raiz, nome);
	}

	// Função auxiliar para remoção recursiva
	private No removerRecursivo(No atual, String nome) {
		if (atual == null) {
			System.out.println("Nome não encontrado na agenda.");
			return null;
		}

		if (nome.compareToIgnoreCase(atual.nome) < 0) {
			atual.esquerdo = removerRecursivo(atual.esquerdo, nome);
		} else if (nome.compareToIgnoreCase(atual.nome) > 0) {
			atual.direito = removerRecursivo(atual.direito, nome);
		} else {
			// Caso 1: nó folha
			if (atual.esquerdo == null && atual.direito == null) {
				return null;
			}

			// Caso 2: um único filho
			if (atual.esquerdo == null) {
				return atual.direito;
			}
			if (atual.direito == null) {
				return atual.esquerdo;
			}

			// Caso 3: dois filhos
			No sucessor = encontrarSucessor(atual.direito);
			atual.nome = sucessor.nome;
			atual.telefone = sucessor.telefone;
			atual.direito = removerRecursivo(atual.direito, sucessor.nome);
		}

		return atual;
	}

	// Encontra o menor nó da subárvore direita
	private No encontrarSucessor(No atual) {
		while (atual.esquerdo != null) {
			atual = atual.esquerdo;
		}
		return atual;
	}
}

// Classe principal para gerenciamento da agenda
public class Guia13 {
	public static void main(String[] args) {
		ArvoreBinaria agenda = new ArvoreBinaria();

		// Leitura do arquivo agenda.txt
		try (BufferedReader br = new BufferedReader(new FileReader("agenda.txt"))) {
			String linha;
			while ((linha = br.readLine()) != null) {
				String[] dados = linha.split(" # ");
				if (dados.length == 2) {
					String nome = dados[0].trim();
					String telefone = dados[1].trim();
					agenda.inserir(nome, telefone);
				} else {
					System.out.println("Linha inválida no arquivo: " + linha);
				}
			}
		} catch (IOException e) {
			System.out.println("Erro ao ler o arquivo: " + e.getMessage());
			return; // Encerra caso o arquivo não seja encontrado
		}

		// Menu
		try (Scanner scanner = new Scanner(System.in)) {
			int opcao;
			do {
				System.out.println("\n=== Menu Agenda ===");
				System.out.println("1. Buscar contato");
				System.out.println("2. Listar contatos em ordem alfabética");
				System.out.println("3. Remover contato");
				System.out.println("4. Sair");
				System.out.print("Escolha uma opção: ");
				opcao = scanner.nextInt();
				scanner.nextLine();

				switch (opcao) {
				case 1:
					System.out.print("Digite o nome para buscar: ");
					String nomeBusca = scanner.nextLine();
					agenda.buscar(nomeBusca);
					break;
				case 2:
					System.out.println("Contatos em ordem alfabética:");
					agenda.listarEmOrdem();
					break;
				case 3:
					System.out.print("Digite o nome para remover: ");
					String nomeRemover = scanner.nextLine();
					agenda.remover(nomeRemover);
					break;
				case 4:
					System.out.println("Encerrando o programa.");
					break;
				default:
					System.out.println("Opção inválida. Tente novamente.");
				}
			} while (opcao != 4);
		}
	}
}
