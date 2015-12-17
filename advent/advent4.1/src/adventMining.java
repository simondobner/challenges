import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class adventMining {

	public static void main(String[] args) {
		/*
		 * --- Day 4: The Ideal Stocking Stuffer ---

			<--SNIP-->	This is identical to 4.1

			--- Part Two ---

			Now find one that starts with six zeroes.
			
			Your puzzle input is still yzbqklnj.

			
		 */
		String hashtext = "";
		Integer counter = 0;
		//String plaintext = "pqrstuv1048970";
		String key = "yzbqklnj";
		
		do {
			hashtext = calculateChecksum(key + counter.toString() );
			System.out.print("counter is " + counter + " md5 is " + hashtext + "\n");
			counter++;
		} while ( ! hashtext.substring(0,6).equals("000000") );
		
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
