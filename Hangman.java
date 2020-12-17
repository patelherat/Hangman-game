package hw2;

import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * @author Ashesh Piyush Sheth, as2462@rit.edu
 * @author Herat Alkeshkumar Patel, hp9198@rit.edu
 */


public class Hangman {
    GameBoard startGame;

    /**
     * sets up the game by creating GameBoard's object
     * @param mode to further pass the difficulty of the game
     * @throws FileNotFoundException to handle exception if dictionary file path not found
     */
    Hangman(LevelMode mode) throws FileNotFoundException {
        startGame = new GameBoard(mode);
    }

    /**
     * calls enterLetter to check validity and continue the game
     */
    public void play()
    {
        Scanner in = new Scanner(System.in);
        while(!startGame.gameOver())
        {
            if(!enterLetter(in))
            {
                System.out.println("Invalid User Input\n");
                System.out.println(startGame.toString());
            }
        }
        in.close();
    }

    /**
     * @param in scans the letter to start and continue the game
     * @return returns false for invalid letter
     */
    private boolean enterLetter(Scanner in)
    {
        String inputLetter;
        System.out.print("Enter a letter: ");
        inputLetter = in.nextLine();

        if(inputLetter.equals("0"))
            System.exit(-1);
        if(inputLetter.length()==1 && ((inputLetter.charAt(0)>='a' && inputLetter.charAt(0)<='z') || (inputLetter.charAt(0)>='A' && inputLetter.charAt(0)<='Z')))
        {
            System.out.println();
            startGame.enterLetter(inputLetter.charAt(0));
            return true;
        }
        else
            return false;
    }

    /**
     * creates Hangman's object to set up the game and calls play to start the game
     * @param args select the difficulty of the game
     * @throws FileNotFoundException to handle exception if dictionary file path not found
     */
    public static void main(String[] args) throws FileNotFoundException {
        LevelMode mode;

        if(args.length==0 || !(args[0].equals("e") || args[0].equals("m") || args[0].equals("h")))
        {
            System.out.println("Usage: java Hangman mode (e – easy, m – medium, h - hard)");
        }
        else
        {
            String hangmanMode = args[0].toLowerCase();
            if(hangmanMode.equals("e"))
                mode = LevelMode.EASY;
            else if(hangmanMode.equals("m"))
                mode = LevelMode.MEDIUM;
            else
                mode = LevelMode.HARD;
            Hangman gameStart = new Hangman(mode);
            gameStart.play();
        }
    }
}
