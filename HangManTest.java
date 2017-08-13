/* Brian Yang
 * BY2225
 * 4/17/17
 * 
 * HangManTest class
 * 
 * This class tests the cheating hang-man game
 */
import java.io.File;

public class HangManTest {

	public static void main(String[] args) {
		
		// Takes in command argument
		try{
			// Gets the file
			File uploadFile = new File(args[0]);
			Game s = new Game(uploadFile);
			// Plays the entire game
			s.play();
		}
		
		// Catches out of bounds exceptions
		catch(ArrayIndexOutOfBoundsException e){
			System.out.print("Include a command argument");
		}
	}
}