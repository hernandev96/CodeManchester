package manchesterP;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**Clase que sirve para generar un archivo**/
public class GenerateDoc {
	/**Metodo que crea un archivo con frases de texto
	 * @param text String texto que contendra el documento
	 * @return archivo File regresa el archivo creado 
	 * **/
	public File CreateText(String text) throws IOException {
		/**Creamos u nuevo archivo**/
		File archivo=new File("original.txt");
		/****/
		FileWriter fw=new FileWriter(archivo);
		/**Escribimos el texto en el archivo**/
		fw.write(text);
		/**cerramos la edicion**/
		fw.close();
		/**Regresamos el archivo creado**/
		return archivo;
	}
}
