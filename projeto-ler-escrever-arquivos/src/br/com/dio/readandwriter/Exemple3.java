package br.com.dio.readandwriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exemple3 {
	public static void main(String[] args) {
		
		try {
			copiarArquivo();
		} catch (IOException e) {
			System.out.println("Erro ao copiar arquivo");
			e.printStackTrace();
		}
	}

	private static void copiarArquivo() throws IOException {
		File file = new File("Recomendacoes.txt");
		String nameArquivo = file.getName();
		
		BufferedReader br = new BufferedReader(new FileReader(nameArquivo));
		String line = br.readLine();
		
		String nameArquivoCopy = nameArquivo.substring(0, nameArquivo.indexOf(".")).concat("-copy.txt");
		File fcopy = new File(nameArquivoCopy);
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(fcopy.getName()));
		
		do {
			bw.write(line);
			bw.newLine();
			bw.flush();
			line = br.readLine();
		} while (!(line == null));
		
		System.out.printf("Arquivo \"%s\" copiado com sucesso! Tamanho:" + file.length() + "\n", file.getName());
		System.out.printf("Arquivo \"%s\" criado com sucesso", fcopy.getName());
		System.out.println();
		System.out.println("Recomende 3 livros: ");
		
		adicionarInfoNoArquivo(fcopy.getName());
		
		System.out.printf("Ok! Tamanho do arquivo: '%d' ", fcopy.length());
		
		br.close();
		bw.close();
		
	}

	private static void adicionarInfoNoArquivo(String arquivo) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, true));
		
		do {
			bw.write(line);
			bw.newLine();
			line = br.readLine();			
		} while(!(line.equalsIgnoreCase("fim")));
		
		br.close();
		bw.close();
	}
}
