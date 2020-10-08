/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 *          Handles responding to simple words and phrases 
 * </li></ul
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie
{
    /**
     * Get a default greeting   
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Hello, let's talk.";
    }
    
    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "";
        if (statement.trim().equals("")){

            response = "Say something please";
        }
        else if (findWord(statement, "no") >= 0)
        {
            response = "Why so negative?";
        }
        else if (findWord(statement, "hi") >= 0
        || findWord(statement, "hello") >= 0)
        {
            response = "How are you?";
        }
        else if (findWord(statement, "mother") >= 0
                || findWord(statement, "father") >= 0
                || findWord(statement, "sister") >= 0
                || findWord(statement, "brother") >= 0)
        {
            response = "Tell me more about your family.";
        }
        else if (findWord(statement, "travel") >= 0){

            response = "I love traveling!";
        }
        else if (findWord(statement, "soccer") >= 0
                || findWord(statement, "basketball") >= 0
                || findWord(statement, "football") >= 0
                || findWord(statement, "hockey") >= 0
                || findWord(statement, "baseball") >= 0
                || findWord(statement, "lacrosse") >= 0
                || findWord(statement, "golf") >= 0)
        {
            response = "Tell me more about that sport.";
        }
        else if (findWord(statement, "ice cream") >= 0
                || findWord(statement, "brownie") >= 0
                || findWord(statement, "cookie") >= 0
                || findWord(statement, "cake") >= 0
                || findWord(statement, "pie") >= 0)
        {
            response = "Dessert is the best.";
        }
        else if (findWord(statement, "cat") >= 0
                || findWord(statement, "dog") >= 0)
        {
            response = "Tell me more about your pets.";
        }
        else if (findWord(statement, "Nathan") >= 0)
        {
            response = "He sounds like a good teacher.";
        }
        else if (findWord(statement, "I want to") >= 0){
            response = transformIWantToStatement(statement);
        }
        else if (findWord(statement, "I want") >= 0){
            response = transformIWantStatement(statement);
        }
        else if (findWord(statement, "I") >= 0
                && findWord(statement, "you") >= 0
                && findWord(statement, "I") < findWord(statement, "you")){
            response = transformIYouStatement(statement);
        }
        else if (findWord(statement, "you") >= 0
                && findWord(statement, "me") >= 0
                && findWord(statement, "you") < findWord(statement, "me")){
            response = transformYouMeStatement(statement);
        }
        else
        {
            response = getRandomResponse();
        }
        return response;
    }
    
    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    public String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 4;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            
            response = "You don't say.";
        }
        else if (whichResponse == 4)
        {
            response = "Wow. How does that work?";
        }
        else if (whichResponse == 5)
        {
            response = "Really?";
        }
        else if (whichResponse == 6)
        {
            response = "I didn't know that";
        }
    
        return response;
    }

    // Checks to see if the String word appears as a whole word
    // in the String str (in this case, a "whole word" means that 
    // word is not just a substring of some larger word in str)

    // This method should work regardless of the capitalization 
    // of str or word

    // The method returns the index of the first character in word
    // if it is found, and returns -1 otherwise. 
    public int findWord(String str, String word) {
        String stri = " " + str.toLowerCase() + " ";
        String words = " " + word.toLowerCase() + " ";
        
        return stri.indexOf(words);
    }

    
    // We will work on the following methods later!

    /**
     * Take a statement with "I want <something>." and transform it into 
     * "Would you really be happy if you had <something>?"
     * @param statement the user statement, assumed to contain "I want"
     * @return the transformed statement
     */
    public String transformIWantStatement(String statement)
    {
        int want = statement.indexOf("I want");
        return ("Would you really be happy if you had" + statement.substring((want + 6), statement.length()) + "?");

    }

    /**
     * Take a statement with "I <something> you" and transform it into 
     * "Why do you <something> me?"
     * @param statement the user statement, assumed to contain "I" followed by "you"
     * @return the transformed statement
     */
    public String transformIYouStatement(String statement)
    {
        int i = findWord(statement, "I");
        int you = findWord(statement, "you");
        return ("Why do you" + statement.substring(i + 1, you) + "me?");
    }

    /**
     * Take a statement with "I want to <something>." and transform it into 
     * "What would it mean to <something>?"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
    public String transformIWantToStatement(String statement)
    {
        int want = statement.indexOf("I want to");
        return ("What would it mean" + statement.substring((want + 6), statement.length()) + "?");
    }



    /**
     * Take a statement with "you <something> me" and transform it into 
     * "What makes you think that I <something> you?"
     * @param statement the user statement, assumed to contain "you" followed by "me"
     * @return the transformed statement
     */
    public String transformYouMeStatement(String statement)
    {
        int you = findWord(statement, "you");
        int me = findWord(statement, "me");
        return ("What makes you think that I" + statement.substring(you + 3, me) + "you?");
    }
}
