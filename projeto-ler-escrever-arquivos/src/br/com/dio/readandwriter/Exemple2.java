package br.com.dio.readandwriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Exemple2 {
	
	//Insira 3 filmes usando o teclado e armazene em um arquivo txt
	public static void main(String[] args) {
		
		try {
			lerTecladoEscreverDocumento();
		} catch (IOException e) {
			System.out.println("Erro ao tentar ler e escrever arquivo");
		}
		
	}

	private static void lerTecladoEscreverDocumento() throws IOException {
		PrintWriter pw = new PrintWriter(System.out);
		pw.println("Digite 3 recomendações de filmes: ");
		pw.flush();
		
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		File file = new File("Recomendacoes.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(file.getName()));
		
		do {
			bw.write(line);
			bw.newLine();
			bw.flush();
			line = scan.nextLine();
		}while (!(line.equalsIgnoreCase("fim")));
		
		
		pw.printf("Arquivo \"%s\" foi criado com sucesso" , file.getName());
		
		pw.close();
		scan.close();
		bw.close();
	}
	
	
}
