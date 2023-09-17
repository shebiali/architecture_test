import java.util.Scanner;

public class InvertPhrase {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a phrase: ");
        String inputString = scanner.nextLine();
        System.out.println("Inverted: " + invertedPhrase(inputString));
    }

    private static String invertedPhrase(String phrase) {

        // Initializing our inverted phrase builder
        StringBuilder invertedPhraseBuilder = new StringBuilder();

        // convert the phrase into char array
        char[] charArray = phrase.toCharArray();

        // initialzing String reference for words
        String word = "";

        // Iterate through the char array in reverse direction
        for (int i = charArray.length - 1; i >= -1; i--) {
            // if the char is space then we got the whole word or if we are standing at the
            // i.e. last index
            // we reverse the word in correct word order and add it to the phrase builder
            // followed by a space
            // and if its a ',' then we put a space after it
            if (i == -1 || Character.isSpaceChar(charArray[i])) {
                // word completed
                word = correctTheWordOrder(word);

                if (invertedPhraseBuilder.length() > 0
                        && invertedPhraseBuilder.charAt(invertedPhraseBuilder.length() - 1) == ',')
                    invertedPhraseBuilder.append(" ");

                invertedPhraseBuilder.append(word).append(" ");

                // make the refernce empty for next word
                word = "";

                // keep '-' in the same place with the correct word order
            } else if (charArray[i] != '-' && !Character.isLetter(charArray[i])
                    && !Character.isSpaceChar(charArray[i])) {

                if (invertedPhraseBuilder.length() > 0)
                    invertedPhraseBuilder.deleteCharAt(invertedPhraseBuilder.length() - 1);

                invertedPhraseBuilder.append(charArray[i]);

            } else // add the char to the word
                word += charArray[i];
        }

        return invertedPhraseBuilder.toString();

    }

    /*
     * 
     */
    private static String correctTheWordOrder(String reversed) {

        String word = "";

        for (int i = reversed.length() - 1; i >= 0; i--)
            word += reversed.charAt(i);

        return word;

    }
}
