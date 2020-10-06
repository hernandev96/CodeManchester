package manchesterP;

public class codeToManchester {

	/**Variable para cambiar un bit aleatoriamente
	 * para hacer la simulacion del ruido
	 *  ***/
	private int random=(int)(Math.random()*10)+1;
	/**Metodo que codifica a manchester sin ruido
	 * @param letra String letra a codificar en manchester
	 * @return codeManchester String letra codificada en manchester
	 * **/
	public String codeManchester(String letra) {
		/**Variable donde guardaremos la letra cifrada en manchester**/
		String codeManchester="";
		/**convertimos la letra que viene en binario en un arreglo de caracteres***/
		char[] digitos=letra.toCharArray();
		for(int i=0;i<digitos.length;i++) {
			/**Aqui hacemos la codificacion en manchester**/
			if(digitos[i]=='0') {
				codeManchester=codeManchester+"01";
			}
			if(digitos[i]=='1'){
				codeManchester=codeManchester+"10";
			}
		}
		return codeManchester;
	}
	/**Metodo que codifica a manchester con ruido
	 * @param letra String letra a codificar en manchester
	 * @return codeManchester String letra codificada en manchester
	 * **/
	public String codeManchester_V2(String letra) {
		/**Variable donde guardaremos la letra cifrada en manchester**/
		String codeManchester="";
		/**convertimos la letra que viene en binario en un arreglo de caracteres***/
		char[] digitos=letra.toCharArray();
		for(int i=0;i<digitos.length;i++) {
			/**Aqui hacemos la codificacion en manchester**/
			if(digitos[i]=='0') {
				/**Aqui modificamos un bit simulando el ruido**/
				if(random==i) {
					codeManchester=codeManchester+"11";
				}else {
					codeManchester=codeManchester+"01";
				}
			}
			if(digitos[i]=='1'){
				if(random==i){
					codeManchester=codeManchester+"11";
				}else {
					codeManchester=codeManchester+"10";
				}
				
			}
		}
		return codeManchester;
	}
	/***
	 * Metodo para decifrar el manchester ademas detecta posibles errores
	 * @param manchestercode String palabra codificada en manchester
	 * @return binario String palabra en binario que no esta codificada en manchester
	 * **/
	public String DecodeToBinary(String manchestercode) throws Exception {
		/**Variable donde se almacenara la palabra descifrada(en binario)**/
		String binario="";
		/**convertimos la letra en manchester en un arreglo de caracteres**/
		char[] codeManchester=manchestercode.toCharArray();
		for(int i=1;i<codeManchester.length;i=i+2){
			/**obtenemos la representacion en manchester para cada bit***/
			String par=String.valueOf(codeManchester[i-1])+String.valueOf(codeManchester[i]);
			/**se decifra el bit**/
			if(par.compareTo("01")==0) {
				binario=binario+"0";
			}if(par.compareTo("10")==0){
				binario=binario+"1";
			}
			/**En caso de errores se detiene la decodificacion y se notifica de un error**/
			if(par.compareTo("11")==0) {
				throw new Exception("Hemos encontrado un error al tratar de decifrar el paquete;");
			}
		}
		
		return binario;
		
	}
}
