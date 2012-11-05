package pruebas;

import java.io.*;

public class HacerDirectorio {

	private static final String fallo=
			"Crear ruta para los directorios... \n" +
			"Crear noseque pa nosecuentas..." +
			"Tiririr que te vi!\n";
	
	private static void fallo(){
		System.err.println(fallo);
		System.exit(1);
	}
	
	private static void listarArchivos(File f){
		System.out.println("Ruta Absoluta: " + f.getAbsolutePath() +
				"\nLeer: " + f.canWrite() +
				"\nEscribir: " + f.canWrite() +
				"\nNombre: " + f.getName() +
				"\nPadre: " + f.getParent() +
				"\nRuta relativa: " + f.getPath() +
				"\nLongitud: " + f.length() +
				"\nUltima modificacion: " + f.lastModified());
		if (f.isFile())
			System.out.println("Existe");
		else if (f.isDirectory())
			System.out.println("Es un directorio");
		
	}
	
	public static void main(String[] args) {
		
		if (args.length<1)
			fallo();
		if (args[0].equals("-r")){
			if (args.length != 3)
				fallo();
		File viejo = new File(args[1]), nuevo = new File(args[2]);
		viejo.renameTo(nuevo);
		listarArchivos(viejo);
		listarArchivos(nuevo);
		return;
		};
		
		
		int contador=0;
		boolean borrar = false;
		if (args[0].equals("-d")){
			contador++;
			borrar = true;
		};
		for ( ; contador<args.length; contador++){
			File f=new File(args[contador]);
			if (f.exists()){
				System.out.println("Existe el archivo... " + f);
				if (borrar){
					System.out.println("Borrando el archivo... " + f);
					f.delete();
					}
			
			else {
				if (!borrar)
					System.out.println("Creando... " + f);
				f.mkdirs();
			}			
	
		}
	listarArchivos(f);
	}
	}
}
