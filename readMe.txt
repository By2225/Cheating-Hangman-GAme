Brian Yang

By2225

Project 5 Cheating HangMan

Names of People I talked to: 
Janil Lema

	For Project 5, the program works exactly as described
in assignment. The Game class is where everything is located while the
 HangManTest class is where it just tests the game. Both of 
 the classes were influenced by the examples written by Cannon,
 the rules of the game, and the tips Cannon gave. 
In this class, I had multiple methods that represented each
function that would make up the game. The first method is
the play method which encapsulates all of the methods necessary
to play the game under one method. Everything is planned out in a
logical process. The openFile method is to open
the file itself and see if it's even there or not. 
This handles an error exception of the file not being there, 
which leads to the termination of the program. The readFile
method is where the program reads the file and asks the user 
for a word length and at the same time, takes in the dictionary
file. The user input is quickly scanned to see if the word 
length exists in the dictionary file or not. There are 
multiple for loops and if statements to iterate through the 
dictionary file and past guesses. The guess method takes
in the user input for the amount of guesses they can make.
The letter method asks the user for a letter and quickly
checks if the previous pattern matches all of the characters
in the past guesses to see if the user already won or not. 
The guess of the letter goes into the pastGuess array list
and checks if there are still guesses left and checks if the
character is a character and has already been entered or not.
The pattern method is to create the hashmap, which contains
the string that represents the pattern and the ArrayList that
contains the words that represent the pattern. With the for 
loop and if statements, it iterates through the current 
dictionary file and puts all of the patterns and words in its
respective order. The biggest family method scans through all
of the array lists in the hash map, gets the biggest array list,
and makes the current array list that biggest array list. Therefore,
the previous dictionary file is cut down. The updating pattern
method always updates the pattern, comparing the past guesses 
and the past pattern. The display pattern is comprised of a
for loop that just simply displays the pattern to the 
user. At the same time, it shows the amount of guesses the user
has left. The printRestOfTheWords method prompts the user
if he/she wants to create a text file that inputs all of
the remaining words they had right before they lost. In the
HangManTest class, I simply input the play method that
contains all of the necessary methods to execute the game 
and handled error exceptions. In addition, it also
allows the program to enter in command arguments and passes
them through. The try and catch handles all of the exceptions
that happen. The HangManTest class and the Game class are
the only classes necessary to run the cheating hang-man 
game. All of the error exception methods were influenced by 
Cannon lecture slides. Both of the classes were influenced
by the logical process and rules of the cheating hangman
exam.