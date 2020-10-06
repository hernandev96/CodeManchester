package manchesterP;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**clase para de codificar cadenas binarias**/
public class Decodificar {

	/**Metodo que decodifica cadenas binarias a letras
	 * @param f File Archivo a decodificar 
	 * **/
	public void decodificar(File f) throws Exception {
		/***Creamos el archivo donde va a estar el texto descifrado**/
		File decodificado=new File("decodificado.txt");
		FileWriter fw=new FileWriter(decodificado); 
		/**Abrimos el archivo que esta cifrado**/
		File binario=f;
		FileReader fr=new FileReader(binario);
		BufferedReader br=new BufferedReader(fr);
		/**Variables para guardar el texto que se va leyendo
		 * las letras decodificadas
		 * y la herramienta que usamos para decodificar***/
		String renglon;
		String letraB;
		codeToManchester decodificar=new codeToManchester();
		/**Checamos que se pueda leer el archivo**/
		if(binario.canRead()) {
			while((renglon=br.readLine())!=null) {
				/***Separamos el texto en las cadenas binarias**/
				String[] palabras=renglon.split(" ");
				for(int i=0;i<palabras.length;i++) {
					if(palabras[i].compareTo("")==0) {
						continue;
					}else {
						/**decodificamos la cadena**/
						letraB=decodificar.DecodeToBinary(palabras[i]);
						/**pasamos la cadena a base 10**/
						Long num=Long.parseLong(letraB, 2);
						/**obtenemos el ASCII de la letra**/
						int letra= Long.hashCode(num);
						/**Imprimimos el resultado**/
						System.out.println(num);
						/**Escribimos la letra en el archivo
						 * la funcion write convierte autamaticamente el ASCII a la letra
						 * que le corresponde
						 * **/
						fw.write(letra);
					}
				}
			}
			fw.close();
		}
		
	}
}
