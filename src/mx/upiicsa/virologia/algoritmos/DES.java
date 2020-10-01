package mx.upiicsa.virologia.algoritmos;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BASE64DecoderStream;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BASE64EncoderStream;

import mx.upiicsa.virologia.modelos.InfoDes;

public class DES { 
	 private static Cipher ecipher;
    private static Cipher dcipher;
 
    private static SecretKey key;
	
	public static InfoDes encrypt(InfoDes infoDes) {
		try {
			key = KeyGenerator.getInstance("DES").generateKey();
			ecipher = Cipher.getInstance("DES");
			infoDes.setLlave(key);
			ecipher.init(Cipher.ENCRYPT_MODE, key);
			byte [] utf8 = infoDes.getCadenaDesencriptada().getBytes("UTF8");
			byte [] enc = ecipher.doFinal(utf8);
			
			enc = BASE64EncoderStream.encode(enc);
			
			
			infoDes.setCadenaEncriptada(new String(enc));
			System.out.println("Encrypted: " + infoDes.getCadenaEncriptada());
			return infoDes; 
		}  catch (Exception e) {
		    e.printStackTrace();	 
		}
		return null;
	}
	
	 public static InfoDes decrypt(InfoDes infoDes) {
		 try {
			 
			 dcipher = Cipher.getInstance("DES");
			 dcipher.init(Cipher.DECRYPT_MODE, infoDes.getLlave());
			 byte[] dec = BASE64DecoderStream.decode(infoDes.getCadenaEncriptada().getBytes());
			 
			 byte[] utf8 = dcipher.doFinal(dec);
			 
			 infoDes.setCadenaDesencriptada(new String(utf8, "UTF8"));
			 System.out.println("Decrypted: " + infoDes.getCadenaDesencriptada() );
			 return infoDes;
		  }catch (Exception e) {
		    e.printStackTrace();
		  }
		  return null;		 
	 } 
		 
	
}
