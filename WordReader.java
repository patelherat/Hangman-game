package hw2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


/**
 * @author Ashesh Piyush Sheth, as2462@rit.edu
 * @author Herat Alkeshkumar Patel, hp9198@rit.edu
 */


public class WordReader {
    private List<String> dict = new ArrayList<>();


    /**
     * @param filename to further read the file by calling the readFile function
     * @throws FileNotFoundException
     */
    WordReader(String filename) throws FileNotFoundException {
        readFile(filename);
    }

    /**
     * @param filename reads the file and sets the list of words
     * @throws FileNotFoundException to handle exception if dictionary file path not found
     */
    private void readFile(String filename) throws FileNotFoundException{
        try{
            File file= new File(filename);
            if(!file.exists())
            {
                System.out.println("Dictionary path not found. Loaded with default dictionary path");
                String defaultDictionaryFile = "/Users/Ashesh/IdeaProjects/Hangman/src/resources/dict.txt";
                file = new File(defaultDictionaryFile);
            }
            Scanner words = new Scanner(file);
            while(words.hasNextLine())
            {
                dict.add(words.nextLine());
            }
            words.close();
        }
        catch (NullPointerException ne)
        {
            System.out.println("Dictionary Path not found. Check path or variable of dictionary file");
            System.exit(0);
        }
    }

    /**
     * randomly picks a word from the list of words
     * @return randomly picked word to be used as hidden word
     */
    String pickHiddenWord(){
        return dict.get(new Random().nextInt(dict.size()));
    }
}
