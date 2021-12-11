/* AP CSA 1 MadLibs Project
 * - By Justin Zhou and Reza Bagheri
 * - 12/10/21
 * 
 * Description: Convert any story into a madlib by replace parts of speech with the names of each part of speech and surrounding the name with <>. 
 *              You can then input your new story into the madLib string and it will then use that to run a madlib game.
 * Preconditions: madLib (String in MadLibs) has a valid madLib style formatted String in it. Process of doing that is documented in description
 * Postconditions: Your completed madlib will be printed out to the console with the parts of speech you input in.
 * 
 * NOTICE: All comments that include info on where program requirements are met are multiline comments
*/

import java.util.Scanner;

public class MadLibs {

    // Replace the madLib string with other madlibs

    String madLib = "I <past tense verb> all the way to <location> in order to <present tense verb> some <plural noun>";
    //String madLib = "The <adjective> <noun> <past tense verb> to the <adjective> <noun> to <present tense verb> all the way to canada.";
    //String madLib = "I woke up early in the morning and looked out the window. There was a <adjective> dog <verb (no -ing)>ing around the <noun>. It sure was going to be a crazy day!";

    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // Create a new instance of the MadLibs class and run the madLibs method.
        // You have to do this since you can't access the non-static variable madLib from a static context which main is.
        MadLibs ml = new MadLibs();
        ml.madLibs();
    }

    public void madLibs() {
       /*
         * Parses parts of speech AND sections to include, loops through x times to get all of them.
         * Follow the comments inside this while loop to see specifics
        */
        // While the madLib still has parts of speech to change.
        // Works since parts of speech are surrounded by < and those will all be gone by the time when the user has inputed all the parts of speech
        while (madLib.indexOf("<") != -1) {
            // Find the indices of the <>'s. These will be used twice so it's better to not inline them and set a variable
            int startingIndex = madLib.indexOf("<");
            int endingIndex = madLib.indexOf(">");

            // These could be inlined but this looks cleaner, it splits the mad lib up into a section BEFORE the part of speech, the PART OF SPEECH, and the text AFTER
            String before = madLib.substring(0, startingIndex);
            String partOfSpeech = madLib.substring(startingIndex + 1, endingIndex);
            String after = madLib.substring(endingIndex + 1);

            /*
             * Prompts like this keep the user on track
            */
            // Get user input for the part of speech based off of the part of speech required
            System.out.println("Please enter a " + partOfSpeech.toLowerCase().replace('_', ' ') + ":");

            /* 
             * Processes user input 
            */
            // Set the madlib to the part BEFORE the part of speech + (concat) the text the user has inputed + the text after the part of speech 
            String nl = scanner.nextLine();
            while (nl.isEmpty()) {
                System.out.println("Please enter a " + partOfSpeech.toLowerCase().replace('_', ' ') + " (do not leave this empty):");
                nl = scanner.nextLine();
            }
            madLib = before + nl + after;
        }

        /*
         * Displays the final madlib
        */
        System.out.println("\nYour final story is....\n" + madLib);
    }
}