import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;


public class analyseStrings {

	public static void main(String[] args) {
		/*
		 * Realizing the error of his ways, Santa has switched to a better model of 
		 * determining whether a string is naughty or nice. None of the old rules 
		 * apply, as they are all clearly ridiculous.

			Now, a nice string is one with all of the following properties:

			It contains a pair of any two letters that appears at least twice in the 
			string without overlapping, like xyxy (xy) or aabcdefgaa (aa),
			 but not like aaa (aa, but it overlaps).
			 
			It contains at least one letter which repeats with exactly one letter 
			between them, like xyx, abcdefeghi (efe), or even aaa.
			
			
			or example:

			qjhvhtzxzqqjkmpb is nice because is has a pair that appears twice (qj) and a letter that repeats with exactly one letter between them (zxz).
			xxyxx is nice because it has a pair that appears twice and a letter that repeats with one between, even though the letters used by each rule overlap.
			
			uurcxstgmygtbstg is naughty because it has a pair (tg) but no repeat with a single letter between them.
			ieodomkazucvgmuy is naughty because it has a repeating letter with one between (odo), but no pair that appears twice.



		 */

		//tests
		//		String textString ="ieodomkazucvgmuy" ;
		//		System.out.print( "repeatingLetterTest result : " +  repeatingLetterTest(textString) + "\n");
		//		System.out.print( "doubleLetterTest result : " +  doubleLetterTest(textString) + "\n");
		//		System.exit(44);
		
		
		String file = "C:\\cygwin64\\home\\u25387\\challenges\\advent\\advent5.1\\src\\stringfile.txt";
		int niceStringCount = 0;
		String textString = "";
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    while ((textString = br.readLine()) != null) {
		    	// 	process this box.
		    	//System.out.print("--> " + textString + "\n");
		    	
				if ( 	repeatingLetterTest(textString) &&
						doubleLetterTest(textString)  ) {
					// then this string passes all tests, so count it up
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

	
	
	private static boolean repeatingLetterTest( String textString ) {
		//the repeating pairs of letters test
		
		// note that it's inefficient to compile the pattern every time
		// we can do it once and then do the test inline instead of calling a method
		// but this lets me document it a bit more clearly :)
		
		
		/* from https://www.reddit.com/r/adventofcode/comments/3viazx/day_5_solutions/
		    . matches any one thing
			.. matches any two things
			(..) ensures that it can be backreferenced, i.e. you can use \1 after it to reference to the two things matched
			.* matches anything, 0 or more times
			(..).*\1 matches any two things, followed by 0 or more things, followed by the same thing matched at the beginning
		 */
		
		
	    Pattern p = Pattern.compile("(..).*\\1");
	    return p.matcher(textString).find(); // passes
	    
	}

	
	
	private static boolean doubleLetterTest( String textString ) {
		// It contains at least one letter which repeats with exactly one letter 
		// between them, like xyx, abcdefeghi (efe), or even aaa.
		
	    Pattern p = Pattern.compile("(.).\\1");
	    return p.matcher(textString).find(); // passes // returns a true if it finds a double letter
   
	}

}
