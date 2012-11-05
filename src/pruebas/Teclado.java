package pruebas;

import java.io.*;

public class Teclado {

	private static BufferedReader br;
	
	
	public static void main(String[] args) throws IOException{
		
		br= new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduzca un numero a mostrar por pantalla");
		String n=br.readLine();
		System.out.println("Has introducido: " + n);
	}

}
