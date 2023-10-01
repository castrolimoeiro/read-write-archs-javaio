package br.com.dio.exempleObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ExempleIOObject {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//serealizacao();
		desserealizacao("gato");
	}

	private static void desserealizacao(String arquivo) throws IOException, ClassNotFoundException{
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo));
		Gato objetoGato = (Gato) ois.readObject();
		
		System.out.println("Nome gato: " + objetoGato.getNome());
		System.out.println("Idade gato: " + objetoGato.getIdade());
		System.out.println("Cor gato: " + objetoGato.getCor());
		
		ois.close();
		
		
	}

	private static void serealizacao() throws IOException {
		Gato gato = new Gato("Simba", 6, "amarelo");
		
		File file = new File("gato");
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file.getName()));
		
		oos.writeObject(gato);
		System.out.println("Arquivo " + file.getName() + " criado com sucesso. Tamanho: " + file.length() );
		oos.close();
	}

}
