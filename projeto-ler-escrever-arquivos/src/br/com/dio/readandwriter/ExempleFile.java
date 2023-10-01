package br.com.dio.readandwriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ExempleFile {

	public static void main(String[] args) {
		//Ex01: Abra o teclado, insira 3 filmes, exiba no console
		
		try {
			receberTecladoImprimirConsole();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private static void receberTecladoImprimirConsole() throws IOException {
		/*InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);*/
		
		System.out.println("Recomende 3 filmes: ");
		//reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String line = br.readLine();
		
		//writer
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		do {
			bw.write(line);
			bw.newLine();
			line = br.readLine();			
		} while (!(line.isEmpty()));
		
		bw.flush();
		
		br.close();
		bw.close();
	}
	
	
}
