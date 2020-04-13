package FinalProject;
/**
 Hangman application picks random country (String) from [], encodes it (for example, Egypt would be encoded as -----),
 and prompts user to guess it letter by letter.
 After each step the result of current round is displayed, as well as mistakes, lives left, already used letters and
 encoded country (for example, if user guessed letter "p", encoded text will be like ---p-).
 After each round game statistics are displayed and application asks user whether user wants to continue.
 If user decides to continue, another country is randomly chosen from the list and encoded.
 */

import java.util.Scanner;
import static java.lang.Character.toLowerCase;

public class Hangman {
    public static void main(String[] args) {
        //declare local variables
        String country; //encoded country
        char guessLetter; //to store user's input
        int mistakeCounter; //to count mistakes while guessing word
        Scanner input = new Scanner(System.in); //object of class Scanner to get input from user
        Methods myHangman = new Methods(); //object of class Methods to run methods of the game
        ResultDisplay myResult = new ResultDisplay(); //object of class ResultDisplay to display results
        boolean continueGame = true;
        char playAgain;
        int gamesWon = 0; //to count games user won
        int gamesLost = 0; // to count lost games

        //processing
        System.out.println("Welcome to Hangman game!\n'Counties in Africa.'");

        //outer loop
        do {
            //call method to pick random country and encode it
            myHangman.randomCountry();

            //call method to calculate correct letters of encoded word
            myHangman.correctLetters();

            //call method to encode country
            country = myHangman.getHangman();

            //display encoded String to user
            System.out.println("\nEncoded country:");
            System.out.println(country);

            //empty stats to start new round
            myHangman.newRound();
            mistakeCounter = myHangman.getMistakeCounter();

            //inner loop (one single game)
            while (mistakeCounter <= 6) {
                //ask user to guess country and store user's input in char guessLetter
                System.out.println("Type letter to guess country:");
                guessLetter = toLowerCase(input.next().charAt(0));

                //use setter method
                myHangman.setGuessLetter(guessLetter);

                //check whether user guessed letter
                // if attempt is correct, replace "-" with correct letter
                myHangman.decode();
                country = myHangman.getHangman();

                //count mistakes' quantity
                myHangman.mistakeCounter();
                mistakeCounter = myHangman.getMistakeCounter();

                //break loop if user made 7 mistakes or completely guessed (if the country is guessed, mistakeCounter ==10)
                if (mistakeCounter == 10 || mistakeCounter == 7) {
                    break;
                }

                //display results of current game round
                myResult.displayResults(mistakeCounter);

                //display encoded country after last guess attempt
                System.out.print("Encoded country: ");
                System.out.println(country);

                //compute and display used letters in current game round
                myHangman.usedLetters();
                System.out.print("Used letters:");
                System.out.println(myHangman.getUsedLetters());

            }//end while

            //update game's statistics
            if(mistakeCounter == 7){
                gamesLost ++;
            }else if(mistakeCounter == 10){
                gamesWon ++;
            }

            //display final results of last round
            myResult.displayResults(mistakeCounter);

            //display puzzled country
            System.out.println("Hidden country: " + myHangman.getCountryToGuess());
            System.out.println();

            //display total games' statistics
            myResult.gameStats(gamesLost, gamesWon);

            //ask user if he wishes to continue, end game if user entered "n"
            System.out.println("Do you wish to continue? y/n");
            playAgain = toLowerCase(input.next().charAt(0));
            if(playAgain == 'n'){
                continueGame = false;
            }

        }while(continueGame);

    }
}
