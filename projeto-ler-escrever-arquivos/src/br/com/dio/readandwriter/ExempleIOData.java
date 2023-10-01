package br.com.dio.readandwriter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class ExempleIOData {

	public static void main(String[] args) throws IOException {
		incluirProduto();
		
	}

	private static void lerProduto(String arquivo) throws IOException {
		File file = new File(arquivo);
		
		DataInputStream dis = new DataInputStream(new FileInputStream(file.getPath()));
		//essa captura tem que ser na mesma ordem que foi incluido no metodo incluirProduto()
		String nome = dis.readUTF();
		char tamanho = dis.readChar();
		int quantidade = dis.readInt();
		double preco = dis.readDouble();
		System.out.printf("Nome: %s\n", nome);
		System.out.printf("Tamanho: %s\n", tamanho);
		System.out.printf("Quantidade: %d\n", quantidade);
		System.out.printf("Preço: %.2f\n", preco);
		
		dis.close();
		
	}

	private static void incluirProduto() throws IOException {
		File file = new File("peca-de-roupa.bin");
		PrintStream ps = new PrintStream(System.out);
		ps.flush();
		
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(file.getPath()));
		Scanner scan = new Scanner(System.in);
		
		ps.print("Nome da peça: ");
		String nome = scan.nextLine();		
		dos.writeUTF(nome);
		
		ps.print("Tamanho da peça (P/M/G/GG): "	);
		char tamanho = (char)System.in.read();
		dos.writeChar(tamanho);
		
		ps.print("Quantidade: ");
		int quant = scan.nextInt();
		dos.writeInt(quant);
		
		ps.print("Preço unitário: ");
		double preco = scan.nextDouble();
		dos.writeDouble(preco);
		
		ps.printf("O arquivo %s foi criado com %d bytes no diretório '%s'.\n", 
				file.getName(), file.length(), file.getAbsolutePath());
		
		lerProduto(file.getPath());
		
		dos.close();
		scan.close();
		ps.close();
	}

}
