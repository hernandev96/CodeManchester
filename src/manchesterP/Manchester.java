package manchesterP;

import java.io.File;
import java.util.Scanner;

public class Manchester {

	public static void main(String[] args) {
		
		try {
			/**Declaracion de variables**/
			Scanner leer=new Scanner(System.in);
			GenerateDoc genera=new GenerateDoc();
			CodificarTexto codificar=new CodificarTexto();
			Decodificar decode=new Decodificar();
			File original;
			File binarioMan;
			String texto;
			/****/
			/**Creacion del archivo a codificar**/
				//Se pregunta por el texto a codificar
			System.out.print("Ingrese el texto a Codificar:");
				///se lee el texto
			texto=leer.nextLine();
				///se crea el archivo con el texto ingresado
			original=genera.CreateText(texto);
			/****/
			/**Codificacion de archivo en codigo manchester**/
			binarioMan=codificar.codificarABinario(original);
			/****/
			/**Decodificacion del archivo en binario**/
			decode.decodificar(binarioMan);
			/****/
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			System.out.println("jejejeje Si me salio :3");
		}

	}

}
