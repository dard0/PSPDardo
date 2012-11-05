package pruebas;

import java.io.*;

public class Ejercicio1 {
	public static void main(String[] args) {
	
		System.out.println("Ficheros en el directorio actual: " + args[0]);
		boolean isDir;
		File f = new File(args[0]);
		File[] aArchivos = f.listFiles();
		for (int i=0; i<aArchivos.length; i++){
			System.out.println(aArchivos[i]);
			System.out.println("Nombre: " + aArchivos[i].getName());
			System.out.println("Patch: " + aArchivos[i].getPath());
			System.out.println("Path Abs: " + aArchivos[i].getAbsolutePath());
			isDir=aArchivos[i].isDirectory();
			if (isDir){
				System.out.println("Es un directorio");
			}
			else {
				System.out.println("Es un archivo");
				System.out.println("Escribible: " + aArchivos[i].canWrite());
				System.out.println("Es Legible: " + aArchivos[i].canRead());
				System.out.println("Tamaño: " + aArchivos[i].getTotalSpace());
			}
					
		}
		
	}

	public static void listar (String ruta){
		File fAux = new File(ruta);
		if (fAux.canRead()){
			File[] archivoAux = fAux.listFiles();
			
			for (int i = 0; i < archivoAux.length; i++){
				System.out.println("Nombre: " + archivoAux[i].getName());
				System.out.println("Path: " + archivoAux[i].getPath());
				System.out.println("Absolute Path: " + archivoAux[i].getAbsolutePath());
				if (archivoAux[i].isDirectory()){
					listar(archivoAux[i].toString());
				}
			}
		}
	}
	
}
