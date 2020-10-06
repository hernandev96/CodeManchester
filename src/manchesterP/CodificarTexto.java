package manchesterP;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**Clase para convertir texto a binario**/
public class CodificarTexto {
	/**
	 * metodo para pasar un archivo de texto a un archivo de numeros binarios
	 * @param f File Archivo que vamos a convertir
	 * @return binario File Archivo que ya esta codificado a binario
	 * @throws Exception 
	 * **/
	public File codificarABinario(File f) throws Exception {
		/**creamos el archivo que estara en binario**/
		File binario=new File("binario.txt");
		FileWriter fw=new FileWriter(binario);
		/**Abrimos el archivo que contiene el texto original **/
		File original=f;
		FileReader fr=new FileReader(f);
		BufferedReader br=new BufferedReader(fr);
		/**Aqui guardaremos el texto leido y la palabra en binario**/
		String line;
		String binarioR;
		/**Verificamos que podamos leer el archivo**/
		if(original.canRead()) {
			/**la condicion del while
			 * Mientras haya lineas que leer se ejecuta el codigo
			 * **/
			while((line=br.readLine())!=null) {
				/**convertimos el texto leido en una cadena de caracteres**/
				char array[]=line.toCharArray();
				/**cada caracter lo convertimos a binario**/
				for(int i=0;i<array.length;i++) {
					/**se crea la cadena binaria que representara una letra**/
					binarioR=charToBinary(array[i]);
					/**Se escribe la cadena**/
					fw.write(binarioR+" ");
					
				}
			}
			/**Se guardan los cambios y se regresa el archivo**/
			fw.close();
			return binario;
		}
		throw new Exception("No se ha podido abrir el archivo original o el archivo esta vacio");
	}
	/**
	 * Metodo para convertir un caracter a una cadena binaria
	 * @param c char caracter a convertir
	 * @return String el caracter convertido a binario
	 * 
	 * ***/
	public String charToBinary(char c) {
		
		String letra=String.valueOf(c);
		codeToManchester codificar=new codeToManchester();
		if(letra.compareTo(" ")==0) {
			return "";
		}
		/**obtenemos el ASCII del caracter**/
		int numero=Integer.valueOf(c);
		/**Se genera la cadena binaria**/
		String binario="0"+Integer.toBinaryString(numero);
		/**Imprimimos la cadena**/
		System.out.println(binario);
		/**Se hace la codificacion a manchester con ruido o sin ruido
		 * Aqui se cambia el metodo dependiendo si queremos manchester con ruido o sin ruido
		 * **/
		return codificar.codeManchester_V2(binario);
	}
}
