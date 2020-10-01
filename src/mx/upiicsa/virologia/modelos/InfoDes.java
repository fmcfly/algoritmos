package mx.upiicsa.virologia.modelos;

import javax.crypto.SecretKey;
//https://examples.javacodegeeks.com/core-java/crypto/encrypt-decrypt-string-with-des/
public class InfoDes {
	private SecretKey llave;
	private String cadenaEncriptada;
	private String cadenaDesencriptada;
	
	public SecretKey getLlave() {
		return this.llave;
	}
	
	public void setLlave(SecretKey llave) {
		this.llave = llave;
	}
	
	public String getCadenaEncriptada() {
		return this.cadenaEncriptada;
	}
	
	public void setCadenaEncriptada(String cadenaEncriptada) {
		this.cadenaEncriptada = cadenaEncriptada;
	}

	public String getCadenaDesencriptada() {
		return cadenaDesencriptada;
	}

	public void setCadenaDesencriptada(String cadenaDesencriptada) {
		this.cadenaDesencriptada = cadenaDesencriptada;
	}	
}
