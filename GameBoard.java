package hw2;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * @author Ashesh Piyush Sheth, as2462@rit.edu
 * @author Herat Alkeshkumar Patel, hp9198@rit.edu
 */


public class GameBoard {
    private String hiddenWord;
    private char[] maskWord;
    private int maxNumTries;
    private Set<String> missedLetters = new HashSet<>();
    private WordReader wordReader;


    /**
     * @param mode uses the difficulty to further get the dict file and max number tries
     * @throws FileNotFoundException to handle exception if dictionary file path not found
     * hidden word is picked and mask word is created
     */
    GameBoard(LevelMode mode) throws FileNotFoundException {
    wordReader = new WordReader(mode.getDictFile());
    maxNumTries = mode.getMaxNumTries();
    hiddenWord = wordReader.pickHiddenWord();
    maskWord = new char[hiddenWord.length()];
    Arrays.fill(maskWord, '*');
    System.out.println("Welcome to the Hangman Game!!\n");
    String currentStatus  = this.toString();
    System.out.println(currentStatus);
    }


    /**
     * overrides toString function to store the current status of the game
     * @return String containing the current status
     */
    public String toString() {
        return "Secret Word: " + String.valueOf(maskWord) + "\nMisses: " + String.join(", ", missedLetters) + "\nNum. of Remaining Tries: " + maxNumTries;
    }

    /**
     * @param guessesLetter guessed letter is checked in hidden word and values for current status is updated
     */
    public void enterLetter(char guessesLetter){
        int position = hiddenWord.toLowerCase().indexOf(guessesLetter);
        if(position==-1)
        {
            int initialSize = missedLetters.size();
            missedLetters.add(String.valueOf(guessesLetter).toUpperCase());
            if(missedLetters.size()!=initialSize)
                maxNumTries--;
        }
        while(position>=0)
        {
            maskWord[position]=Character.toUpperCase(guessesLetter);
            position = hiddenWord.toLowerCase().indexOf(guessesLetter, position+1);
        }
        String currentStatus  = this.toString();
        System.out.println(currentStatus);
    }


    /**
     * @return true if max tries are 0 or secret word is guessed; else false to continue the game
     */
    public boolean gameOver()
    {
        if(maxNumTries==0)
        {
            System.out.println("Game Over! The secret word was "+hiddenWord);
            return true;
        }
        else if(String.valueOf(maskWord).equalsIgnoreCase(hiddenWord))
        {
            System.out.println("You guessed the secret word");
            return true;
        }
        else
            return false;
    }
}
