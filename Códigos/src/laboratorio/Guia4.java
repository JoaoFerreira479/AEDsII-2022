package laboratorio;

import java.util.ArrayList;
import java.util.List;

// Classe abstrata representando um Animal
abstract class Animal {
	private String nome;

	public Animal() {
	}

	public Animal(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	// Métodos abstratos da fala do animal
	public abstract void setFala(String fala);

	public abstract String getFala();
}

// Subclasse para representar um Homem
class Homem extends Animal {
	private String fala;

	public Homem() {
		super();
	}

	public Homem(String nome) {
		super(nome);
		this.fala = "Oi";
	}

	@Override
	public void setFala(String fala) {
		this.fala = fala;
	}

	@Override
	public String getFala() {
		return fala;
	}
}

// Subclasse para representar um Cão
class Cao extends Animal {
	private String fala;

	public Cao() {
		super();
	}

	public Cao(String nome) {
		super(nome);
		this.fala = "Au au";
	}

	@Override
	public void setFala(String fala) {
		this.fala = fala;
	}

	@Override
	public String getFala() {
		return fala;
	}
}

// Subclasse para representar um Gato
class Gato extends Animal {
	private String fala;

	public Gato() {
		super();
	}

	public Gato(String nome) {
		super(nome);
		this.fala = "Miau";
	}

	@Override
	public void setFala(String fala) {
		this.fala = fala;
	}

	@Override
	public String getFala() {
		return fala;
	}
}

public class Guia4 {
	public static void main(String[] args) {

		// Lista para armazenar objetos do tipo Animal
		List<Animal> animais = new ArrayList<>();

		// Adicionando objetos à lista
		for (int i = 0; i < 5; i++) {
			animais.add(new Homem("Homem " + (i + 1)));
			animais.add(new Cao("Cão " + (i + 1)));
			animais.add(new Gato("Gato " + (i + 1)));
		}

		// Exibindo falas
		exibirFalas(animais);
	}

	// Método para exibir as falas de todos os animais na lista
	private static void exibirFalas(List<Animal> animais) {
		System.out.println("Animais falando:");
		for (Animal animal : animais) {
			System.out.println(animal.getNome() + ": " + animal.getFala());
		}
	}
}
