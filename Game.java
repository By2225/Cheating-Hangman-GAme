/* Brian Yang
 * BY2225
 * 4/17/17
 * 
 * Game class
 * 
 * This class represents the cheating hang-man game
 * incorporating all of the rules given by Cannon
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Game {

	// Initializing instance variables
	private ArrayList <String> current;
	private ArrayList <String> patternDisplay; 
	private ArrayList <String> pastGuesses;
	private HashMap <String, ArrayList<String>> patternMap;
	private Scanner dict;
	private double guesses;
	private String character;
	private String pattern;
	private boolean win;
	private double finalGuessCount;
	private File lamp;
	private boolean yes;
	private int calendar;
	
	// Assign a constructor and initializing variables
	public Game(File uploadFile) {
		// Initializing variables
		current = new ArrayList<>();
		patternDisplay = new ArrayList<>();
		pastGuesses = new ArrayList<>();
		patternMap = new HashMap <String, ArrayList<String>>();
		win = false;
		lamp = uploadFile;
	}
	
	// Method to play the whole game
	public void play(){
		
		// boolean value to play the game again
		yes = true;
	
		while (yes){
			// beginning of the game to open a
			// file and to guess a letter
			openFile();
			readFile();
			guess();
			
			// Takes user input to see the text file
			System.out.print("Do you want to print a "
					+ "txt file of the remaining words?");
			System.out.print(" Type 1 for Yes. Type 2 for No.");
			Scanner lamp = new Scanner(System.in);
			int marker = lamp.nextInt();
			
			// Takes user input to see the running total
			// of words
			System.out.print("Do you want to "
					+ "see a running total of" +
					 " of the number of words remaining?");
			System.out.print(" Type 1 for Yes. Type 2 for No.");
			Scanner clock = new Scanner(System.in);
			calendar = clock.nextInt();

		// The game lasts till the amount
		// of guesses run out
		while(getGuess() > 0){

			letter();
			pattern();
			biggestWordFamily();
			updatesPattern();
			displaysPattern();
			}
			
		// Depending on user input
		// it prints the the text file 
		// for the rest of the words
		if (marker == 1){
			printRestOfWords();
		}
		
			System.out.println();
			System.out.print("Do you want to play again?");
			System.out.print(" Type 1 for Yes. Type 2 for No.");
			
			// Clears the pattern display
			// and the forbidden characters array-list
			pastGuesses.clear();
			patternDisplay.clear();
			
			// Takes user input, so the game 
			// can start again
			Scanner phone = new Scanner(System.in);
			int bottle = phone.nextInt();
			if (bottle != 1){
				yes = false;
			}
		}
	}
	
	// Method to enter the file
	// and checks for the file
	private void openFile(){
		try{
		dict = new Scanner(lamp);
	}
		// Catches and handles error exception
		catch (Exception e){
			System.out.println("File not found.");	
			System.out.println("Enter the correct file name.");	
			System.exit(0);
		}
	}
	
	// Method to read the file
	private void readFile(){
		// Takes user input for wordlength
		System.out.print("Please enter "
				+ "the desired word length");
		Scanner input = new Scanner(System.in);
		int wordLength = input.nextInt();
		
		// Enters the dictionary.txt file
		try{
			boolean ball = true;
			// Depending on if there are still guesses
			// left or if the user won, then the game
			// will end
			while(ball){
				dict = new Scanner(new File ("dictionary.txt"));
				current = new ArrayList<String>();
				
				// Executives if there's a word
				// in the next line
				while (dict.hasNextLine()){
					String a = dict.nextLine();
					
					// Checks if the words fit
					// the user input's word-length
					if(a.length() == wordLength){
						current.add(a);
					}
				}
				
				// Creates the pattern display
				for (int i= 0; i < wordLength; i++){
					patternDisplay.add("_");
				}
				
				// If the array-list is empty
				// then no such word-length exists
				if (current.isEmpty()){
					System.err.println("Invalid word length. " 
							+ "Please try again");
					wordLength = input.nextInt();
				}
				else{
					ball = false;
				}	
			}
		}
		
		// Catches an exception
		catch (Exception e){
			e. printStackTrace();
		}
	}
	
	// Method to take in a guess
	private void guess(){
		System.out.print("How many guesses "
				+ "would you like to make?");
		System.out.print(" Type in an integer value");
		// User input is seen as amount of guesses
		Scanner number = new Scanner(System.in);
		guesses = number.nextDouble();
	}
	
	// Method to return the amount of guesses
	private double getGuess(){
		return guesses;
	}
	
	// Method to take in a letter
	private void letter(){
		boolean car = true;
		
		while (car){
			// Checks if the user won or not
			if(!patternDisplay.contains("_")){
				
				System.out.println();
				System.out.println("You just won!!!!");
				// boolean values to stop the game if
				// the user won
				win = false;
				car = false;
				// Shows the final count
				finalGuessCount = guesses;
				guesses = 0;
				break;
			}
			
			// Takes the scanner input for a letter
			System.out.println();
			System.out.print("Guess a letter");
			Scanner reader = new Scanner(System.in);
			character = reader.nextLine();
			char character2 = character.charAt(0);
			
			// Checks if the user input is
			// equal to a character
			if (Character.isLetter(character2) && 
					!(pastGuesses.contains(character))){
				
				// Adds the input into past guesses
				pastGuesses.add(character);	
				car = false;
			}else{
				System.out.print("Enter an actual letter "
						+ "that hasn't been used yet");
					}
			// Checks if the user ran out of guesses
			if(guesses <= 0){
				System.out.println("You just ran out of guesses");
				break;
			}
		}
	}
		
	// Method to create a Hashmap
	// to group the patterns and word families
	private void pattern(){
			
			// Traverses through the current dictionary words
			for (int i = 0; i < current.size(); i++){
				pattern = "";
				
				// Goes through word
				for (int k = 0; k < current.get(i).length(); k++){
					
					// If the user-input is equal to the
					// word, it separates itself
					// into its proper word family
					if (current.get(i).charAt(k) == 
							character.charAt(0)){
					pattern += character;
				}
					// Creates the dash 
					else{
					pattern += "_ ";
				}
			}	
				// Assorts the words into its array list
				if(patternMap.get(pattern) != null){
					patternMap.get(pattern).add(current.get(i));			
				}
				else{
					// Creates a new array list
					// for each new pattern
					patternMap.put(pattern, new ArrayList<String>());
					patternMap.get(pattern).add(current.get(i));
				}
			}	
	}	
	
	// Method to get the biggest word family
	private void biggestWordFamily(){
		ArrayList<String> max = null;
		
		// Goes through all of the array lists
		// and keeps the biggest one
		for (ArrayList<String> list: patternMap.values()){
			if (max == null || list.size() > max.size()){
				max = list;
				current = max; 
			}
		}
		
		// Depending on user input, it'll
		// show the amount of words left
		if (calendar == 1){
			System.out.print("Amount of words left: " 
					+ current.size());
		}
		// Clears the hash-map keys and values
		System.out.print("\n");
		patternMap.clear();
	}
	
	// Method to keep updating the pattern
	private void updatesPattern(){
		
	// Traverses through previous pattern
	for (int i = 0; i < patternDisplay.size(); i++){
		// Checks if any of the past guesses
		// matches any of the letters in
		// the current pattern
			
		if (current.get(0).charAt(i)
				==character.charAt(0)){
				
			// Keeps updating the pattern
			patternDisplay.set(i, 
					(pastGuesses.get(pastGuesses.size()-1)));
			}
		}
	}

	// Method to display the pattern
	// to the user
	private void displaysPattern(){
		// Traverses through the pattern
		for(int j = 0; j < patternDisplay.size(); j++){
		// Prints out the pattern
		System.out.print(patternDisplay.get(j) + " ");
	}
		System.out.println();
		// Guesses decreases, if the character
		// doesn't belong
		if(!patternDisplay.contains(character)){
			guesses--;
		}			
		// Prints out the amount of guesses left
		if (guesses!=0){
		System.out.println("Amount of guesses left: " + guesses);
		}
		else{
			System.out.println("Amount of guesses left: " 
					+ finalGuessCount);
			System.out.println("The word is " + current.get(0));
		}
	}
	
	// Method to return the boolean
	// value to play the game again
	private boolean getWin(){
		return win;
	}
	
	// Method to print a txt file
	// that contains the rest of the words
	private void printRestOfWords(){
		try{
			// Creates the text file
			PrintWriter RestOfTheWords =
					new PrintWriter("RestOfTheWords.txt");
			// Prints each individual word
			for (int k = 0; k< current.size(); k++){
				RestOfTheWords.println(current.get(k));
			}
			// closes the file
			RestOfTheWords.close();
		}
		// Catches an IOExceptions
		catch (IOException e){
			System.out.println("File not found");
		}
	}
}