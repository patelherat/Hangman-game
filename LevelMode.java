package hw2;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;


/**
 * @author Ashesh Piyush Sheth, as2462@rit.edu
 * @author Herat Alkeshkumar Patel, hp9198@rit.edu
 */


public enum LevelMode {

    EASY,
    MEDIUM,
    HARD;

    private static final int DEFAULT_MAXIMUM_NUM_TRIES = 8;
    private static final String DEFAULT_DICTIONARY_FILE = "/Users/Ashesh/IdeaProjects/Hangman/src/resources/dict.txt";
    private static final String CONFIG = "/resources/config.properties";
    private static Properties prop = new Properties();
    private String dictFile;
    private int maxNumTries;

    /**
     * private constructor included so that javadoc does not generate documentation for the default constructor
     */
    private LevelMode(){
    }

    /**
     * @return String containing the path of dictionary file
     */
    public String getDictFile(){
        init();
        if(dictFile==null)
            return DEFAULT_DICTIONARY_FILE;

        return dictFile;
    }

    /**
     * @return Integer containing the number of max tries
     */
    public int getMaxNumTries()
    {
        if(maxNumTries==0)
            return DEFAULT_MAXIMUM_NUM_TRIES;

        return maxNumTries;
    }

    /**
     * loads the config file and sets the dictionary file and max tries according to the difficulty
     */
    private void init()
    {
        try {
            prop.load(Hangman.class.getResourceAsStream(CONFIG));
            if(this.toString().equals("EASY") || this.toString().equals("MEDIUM"))
                dictFile = prop.getProperty("easy.dict");
            else
                dictFile = prop.getProperty("hard.dict");

            if(this.toString().equals("EASY"))
                maxNumTries = Integer.parseInt(prop.getProperty("easy.tries"));
            else
                maxNumTries = Integer.parseInt(prop.getProperty("hard.tries"));
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("Max tries not found. Loaded with default max tries.");
            maxNumTries=0;
        }
        catch (NullPointerException npe)
        {
            System.out.println("Config file not found. Loaded with default dictionary and max tries.");
            maxNumTries=0;
        }
        catch (IOException io) {
            io.printStackTrace();
        }
    }
}
