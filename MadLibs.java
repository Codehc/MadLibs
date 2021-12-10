import java.util.Scanner;

public class MadLibs {
    String madLib = "I woke up early in the morning and looked out the window. There was a <adjective> dog <verb (no -ing)>ing around the <noun>. It sure was going to be a crazy day!";

    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // Create a new instance of the MadLibs class and run the madLibs method.
        // You have to do this since you can't access the non-static variable madLib from a static context which main is.
        MadLibs ml = new MadLibs();
        ml.madLibs();
    }

    public void madLibs() {
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

            // Get user input for the part of speech based off of the part of speech required
            System.out.println("Please enter a " + partOfSpeech.toLowerCase().replace('_', ' ') + ":");
            // Set the madlib to the part BEFORE the part of speech + (concat) the text the user has inputed + the text after the part of speech 
            madLib = before + scanner.nextLine() + after;
        }
        System.out.println("\nYour final story is....\n" + madLib);
    }
}