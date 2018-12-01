import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class adventMining {

	public static void main(String[] args) {
		/*
		 * --- Day 4: The Ideal Stocking Stuffer ---

			Santa needs help mining some AdventCoins (very similar to bitcoins) to use as gifts 
			for all the economically forward-thinking little girls and boys.
			
			To do this, he needs to find MD5 hashes which, in hexadecimal, start with at 
			least five zeroes. The input to the MD5 hash is some secret key (your puzzle input, 
			given below) followed by a number in decimal. To mine AdventCoins, you must 
			find Santa the lowest positive number (no leading zeroes: 1, 2, 3, ...) 
			that produces such a hash.
			
			For example:
			
			If your secret key is abcdef, the answer is 609043, because the MD5 hash
			of abcdef609043 starts with five zeroes (000001dbbfa...), and it is the lowest 
			such number to do so.
			If your secret key is pqrstuv, the lowest number it combines with to make an 
			MD5 hash starting with five zeroes is 1048970; that is, the MD5 hash of
			pqrstuv1048970 looks like 000006136ef....
			
			Your puzzle input is yzbqklnj.

			Crikey!
			
		 */
		String hashtext = "";
		Integer counter = 0;
		//String plaintext = "pqrstuv1048970";
		String key = "yzbqklnj";
		
		do {
			hashtext = calculateChecksum(key + counter.toString() );
			System.out.print("counter is " + counter + " md5 is " + hashtext + "\n");
			counter++;
		} while ( ! hashtext.substring(0,5).equals("00000") );
		
	}

	private static String calculateChecksum(String plaintext) {
		MessageDigest m;
		String hashtext ="";
		try {
			m = MessageDigest.getInstance("MD5");
			m.update(plaintext.getBytes());
			byte[] digest = m.digest();
			BigInteger bigInt = new BigInteger(1,digest);
			hashtext = bigInt.toString(16);
			// Now we need to zero pad it if you actually want the full 32 chars.
			while(hashtext.length() < 32 ){
			  hashtext = "0"+hashtext;
			}
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hashtext;
	}

}
