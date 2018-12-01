import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class analyseStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String textString ="dvszwmarrgswjxmb" ;
		
//		threeVowelTest(textString);
//		doubleLetterTest(textString);
//		badStringTest(textString);
		
//		System.out.print( threeVowelTest(textString) );
//		System.out.print( doubleLetterTest(textString ));
//		System.out.print( badStringTest(textString ));

		
		String file = "C:\\cygwin64\\home\\u25387\\challenges\\advent\\advent5.1\\src\\stringfile.txt";
		int niceStringCount = 0;
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    while ((textString = br.readLine()) != null) {
		    	// 	process this box.
		    	//System.out.print("--> " + textString + "\n");
		    	
				if ( 	threeVowelTest(textString) &&
						doubleLetterTest(textString) &&
						badStringTest(textString) ) {
					// then this string passes all three tests, so count it up
					niceStringCount++;
				}

		    }
		    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print("nice string count is " + niceStringCount + "\n");
		
	}

	
	private static boolean badStringTest(String textString) {
		//ab, cd, pq, or xy
		Pattern p_ab = Pattern.compile("ab");
		Pattern p_cd = Pattern.compile("cd");
		Pattern p_pq = Pattern.compile("pq");
		Pattern p_xy = Pattern.compile("xy");
		
		
		if ( 	p_ab.matcher(textString).find() ||
				p_cd.matcher(textString).find() ||
				p_pq.matcher(textString).find() ||
				p_xy.matcher(textString).find() ) {
			return false; // bad string
		}
		return true; // it's a good string, didn't find any ab, cd, pq or xy strings
	}
	
	
	
	private static boolean doubleLetterTest( String textString ) {

	    Pattern p = Pattern.compile("(\\w)\\1+");
	    Matcher m = p.matcher(textString); // passes

	    return m.find(); // returns a true if it finds a double letter
   
	}
	
	
	
	private static boolean threeVowelTest( String textString ) {
		int counter = 0;
		
		//the 3 vowels test
	    Pattern p = Pattern.compile("[aeiou]");
	    Matcher m = p.matcher(textString); // passes
	    
	    while ( m.find()) 
	    	counter++;
	    
	    if (counter < 3 ) {
	    	return false; // not enough vowels
	    } else {
	    	return true; //yep, at least 3 vowels found
	    }
	    
	}

}
