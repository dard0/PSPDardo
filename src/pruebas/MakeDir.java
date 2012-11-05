package pruebas;

import java.io.*;

public class MakeDir {

	private final static String fallo=(
			"Uso: Para crear directorios ruta1... \n" +
			"Uso: Para tal y cual pipas ... \n" + 
			"Uso: Para pipas y longanizas ... \n");
	
	
	private static void fallo(){
		System.err.println(fallo);
		System.exit(1);
	}
	
	private static void datosArchivos(File f){
		System.out.println(
				"Ruta Absoluta: " + f.getAbsolutePath() +
				"\n Ruta Relativa: " + f.getPath() +
				"\n Escribibile: " + f.canWrite() +
				"\n Leeible: " + f.canRead() +
				"\n Nombre: " + f.getName() +
				"\n Padre: " + f.getParent() +
				"\n Longitud: " + f.length() +
				"\n Ultima Modificacion: " + f.lastModified());
				if (f.isFile())
					System.out.println("Es Archivo");
				else if (f.isDirectory())
					System.out.println("Es Directorio");
	}
	
	
	public static void main(String[] args) {

		if (args.length < 1)
			fallo();
		if (args[0].equals("-r")){
			if (args.length != 3)
				fallo();
			File viejo = new File(args[1]), nuevo = new File(args[2]);
			viejo.renameTo(nuevo);
			datosArchivos(viejo);
			datosArchivos(nuevo);
			return;
			}

		int contador = 0;
		boolean borrar = false;
		if (args[0].equals("-d")){
			borrar=true;
			contador++;
			}
		for (; contador<args.length; contador++){
			File f = new File(args[contador]);
			if (f.exists()){
				System.out.println("El Archivo "+ f + " Existe");
				if (borrar){
					System.out.println("Borrando archivo... " + f);
					f.delete();
				}
			}
			else {
				if (!borrar){
					f.mkdirs();
					System.out.println("Creando... " + f);
				}
			}
			datosArchivos(f);
			
				}
			}
		
	}

