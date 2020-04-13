package FinalProject;

import java.util.Random;

import static java.lang.Character.toLowerCase;

public class Methods {
    //declare local variables
    private String[] countries = {"Algeria", "Angola", "Benin", "Botswana", "Burkina Faso", "Burundi", "Cameroon",
                                    "Cabo Verde", "Chad", "Comoros", "Congo", "Djibouti", "Egypt", "Equatorial Guinea",
                                    "Eritrea", "Eswatini", "Ethiopia", "Gabon", "The Gambia", "Ghana", "Guinea",
                                    "Guinea Bissau", "Kenya", "Lesotho", "Liberia", "Libya", "Madagascar", "Malawi",
                                    "Mali", "Mauritania", "Mauritius", "Morocco", "Mozambique", "Niger", "Nigeria",
                                    "Rwanda", "Senegal", "Seychelles", "Sierra Leone", "Somalia", "South Africa",
                                    "South Sudan", "Sudan", "Tanzania", "Togo", "Tunisia", "Uganda", "Zambia", "Zimbabwe"};

    private String countryToGuess;
    private String hangman;//to store guessed String
    Random rnd = new Random();
    //create an object of type StringBuffer to build the encoded text
    StringBuffer sb = new StringBuffer();
    private int len; //length of country to guess
    private char guessLetter;
    private String correctLetters; //to store correct letters of encoded String
    private String usedLetters = " "; //to store user's input
    private int mistakeCounter = 0;

    //declare constructor
    public Methods() {
    }

    //method to randomly pick country from countries[] and encode it
    public void randomCountry(){
        countryToGuess = countries[rnd.nextInt(countries.length)];
        //len - the number of chars in text
        len = countryToGuess.length();
        sb.setLength(0);

        for(int i = 0; i < len; i++){
            char c = countryToGuess.charAt(i);
            //if there is space add space itself to the encoded text
            if(c == ' '){
                sb.append(c);
            }else{
                sb.append('-');
            }
        }
        //store the encoded word into a String variable to convert the StringBuffer object to a String object
        hangman = sb.toString();
    }

    //setter for char guessLetter
    public void setGuessLetter(char guessLetter) {
        this.guessLetter = guessLetter;
    }
    public void decode(){
        sb.setLength(0);
        for (int j = 0; j<len; j++){
            char y = toLowerCase(countryToGuess.charAt(j));
            if(guessLetter == y){
                sb.append(countryToGuess.charAt(j));
            }else{
                sb.append(hangman.charAt(j));
            }
        }
        hangman = sb.toString();
    }

    //make String with correct letters from encoded country
    public void correctLetters(){
        sb.setLength(0);
        int idx;
        for (int i = 0; i < countryToGuess.length(); i++) {
            char c = toLowerCase(countryToGuess.charAt(i));
            idx = countryToGuess.indexOf(c, i + 1);
            if (idx == -1) {
                sb.append(c);
            }
        }
        correctLetters = sb.toString().replaceAll(" ","");
    }

    //if user's input letter is not used, add it to used letters
    public void usedLetters(){
        sb.setLength(0);
        int used = 0;
        for (int i = 0; i < usedLetters.length(); i++){
            char w = usedLetters.charAt(i);
            sb.append(w);
            if(guessLetter == w){
                used ++;
            }
        }
        if(used == 0){
           sb.append(guessLetter);
            sb.append(" ");
       }
        usedLetters = sb.toString();
    }

    //method to count mistakes; if the country is guessed, mistakeCounter is assigned to 10
    public void mistakeCounter(){
        if(hangman.equalsIgnoreCase(countryToGuess)){
            mistakeCounter = 10;
        //if letter is neither used nor correct, mistakeCounter +=1
        }else if(usedLetters.indexOf(guessLetter) < 0 && correctLetters.indexOf(guessLetter) < 0){
            mistakeCounter +=1;
        }
    }

    //to start new round, set used letters and mistakeCounter to zero values;
    public void newRound () {
        mistakeCounter = 0;
        usedLetters = " ";
    }

    //getters
    //getter for country to guess
    public String getCountryToGuess() {
        return countryToGuess;
    }

    //getter for encoded text
    public String getHangman() {
        return hangman;
    }

    //getter for used letters
    public String getUsedLetters() {
        return usedLetters;
    }

    //getter for mistakeCounter
    public int getMistakeCounter() {
        return mistakeCounter;
    }

}//end class
