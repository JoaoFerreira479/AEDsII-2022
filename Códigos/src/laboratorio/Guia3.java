package laboratorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Classe para representar uma Pessoa
class Pessoa {
	private String nome;
	private int idade;
	private double renda;

	// Construtor da classe Pessoa
	public Pessoa(String nome, int idade, double renda) {
		this.nome = nome;
		this.idade = idade;
		this.renda = renda;
	}

	// Método para exibir informações da Pessoa como string
	@Override
	public String toString() {
		return "Nome: " + nome + ", Idade: " + idade + ", Renda: " + renda;
	}
}

// Classe para representar um Livro
class Livro {
	private String titulo;
	private String autor;
	private String assunto;
	private int id;

	// Construtor da classe Livro
	public Livro(String titulo, String autor, String assunto, int id) {
		this.titulo = titulo;
		this.autor = autor;
		this.assunto = assunto;
		this.id = id;
	}

	// Método para exibir informações do Livro como string
	@Override
	public String toString() {
		return "Título: " + titulo + ", Autor: " + autor + ", Assunto: " + assunto + ", ID: " + id;
	}
}

public class Guia3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			// Exercício 1: Ler e exibir uma única Pessoa
			Pessoa pessoa = lerPessoa(scanner);
			System.out.println("\nDados da pessoa:");
			System.out.println(pessoa);

			// Exercício 2: Ler e exibir uma lista de Pessoas
			List<Pessoa> pessoas = lerListaPessoas(scanner, 5);
			System.out.println("\nDados do vetor de pessoas:");
			pessoas.forEach(System.out::println);

			// Exercício 3: Ler e exibir uma lista de Livros
			List<Livro> livros = lerListaLivros(scanner, 5);
			System.out.println("\nDados do vetor de livros:");
			livros.forEach(System.out::println);

		} catch (Exception e) {
			System.err.println("Erro: " + e.getMessage());
		} finally {
			scanner.close();
		}
	}

	// Método para ler os dados de uma Pessoa
	private static Pessoa lerPessoa(Scanner scanner) {
		System.out.println("Exercício 1: Pessoa única");
		System.out.print("Digite o nome: ");
		String nome = scanner.nextLine();
		System.out.print("Digite a idade: ");
		int idade = scanner.nextInt();
		System.out.print("Digite a renda: ");
		double renda = scanner.nextDouble();
		scanner.nextLine();
		return new Pessoa(nome, idade, renda);
	}

	// Método para ler uma lista de Pessoas
	private static List<Pessoa> lerListaPessoas(Scanner scanner, int quantidade) {
		System.out.println("\nExercício 2: Vetor de Pessoas");
		List<Pessoa> pessoas = new ArrayList<>();

		for (int i = 0; i < quantidade; i++) {
			System.out.println("\nPessoa " + (i + 1) + ":");
			System.out.print("Digite o nome: ");
			String nome = scanner.nextLine();
			System.out.print("Digite a idade: ");
			int idade = scanner.nextInt();
			System.out.print("Digite a renda: ");
			double renda = scanner.nextDouble();
			scanner.nextLine();
			pessoas.add(new Pessoa(nome, idade, renda));
		}

		return pessoas;
	}

	// Método para ler uma lista de Livros
	private static List<Livro> lerListaLivros(Scanner scanner, int quantidade) {
		System.out.println("\nExercício 3: Vetor de Livros");
		List<Livro> livros = new ArrayList<>();

		for (int i = 0; i < quantidade; i++) {
			System.out.println("\nLivro " + (i + 1) + ":");
			System.out.print("Digite o título: ");
			String titulo = scanner.nextLine();
			System.out.print("Digite o autor: ");
			String autor = scanner.nextLine();
			System.out.print("Digite o assunto: ");
			String assunto = scanner.nextLine();
			System.out.print("Digite o ID: ");
			int id = scanner.nextInt();
			scanner.nextLine();
			livros.add(new Livro(titulo, autor, assunto, id));
		}
		
		return livros;
	}
}
