package pruebas;

import java.io.*;
import java.util.Vector;

//captura la salida (stdio) de un proceso externo

public class E01_Execute {
	public static void main(String args[]) {
		try {
			String linea;
			Vector<Process> procesos = new Vector<>(args.length);
			Vector<BufferedReader> flujosEntrada = new Vector<>(args.length);
			Vector<BufferedReader> flujosErrores = new Vector<>(args.length);
			
			for (int i = 0; i < args.length; i++){
				procesos.add(Runtime.getRuntime().exec(args[i]));
				flujosEntrada.add(new BufferedReader(new InputStreamReader(
					procesos.elementAt(i).getInputStream())));
				flujosErrores.add(new BufferedReader(new InputStreamReader(
						procesos.elementAt(i).getErrorStream())));
			}
			

			for (int i = 0; i < args.length; i++){

			// std input
			while ((linea = flujosEntrada.elementAt(i).readLine()) != null) {
				System.out.println(linea);
			}
			flujosEntrada.elementAt(i).close();

			// stderr
			while ((linea = flujosErrores.elementAt(i).readLine()) != null) {
				System.out.println(linea);
			}
			flujosErrores.elementAt(i).close();


			
			Thread.sleep(5000);
			procesos.elementAt(i).destroy();
			System.out.println(args[i]+ " Devuelve: " + procesos.elementAt(i).exitValue());
			procesos.elementAt(i).waitFor(); // esperar			

			}
			System.out.println("Fin.");
		} catch (Exception err) {
			err.printStackTrace();
		}
	}
}
