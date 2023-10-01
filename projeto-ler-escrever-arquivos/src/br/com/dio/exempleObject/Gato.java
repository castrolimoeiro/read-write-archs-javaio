package br.com.dio.exempleObject;

import java.io.Serializable;

public class Gato implements Serializable{
	
	private static final long serialVersionUID = 2L;
	private String nome;
	private int idade;
	private String cor;
	private boolean castrado;

	public Gato() {
		
	}
	
	public Gato(String nome, int idade, String cor) {
		this.nome = nome;
		this.idade = idade;
		this.cor = cor;
	}

	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	public String getCor() {
		return cor;
	}

	@Override
	public String toString() {
		return "Gato [nome=" + nome + ", idade=" + idade + ", cor=" + cor + "]";
	}

	
	
	
}
