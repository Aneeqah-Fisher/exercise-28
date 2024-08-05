import java.util.Scanner;
import java.util.Random;

public class Hangman {
    private static final String[] WORDS = {"java", "python", "hangman", "programming", "computer"};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain;

        do {
            String word = WORDS[random.nextInt(WORDS.length)];
            char[] guessedWord = new char[word.length()];
            for (int i = 0; i < guessedWord.length; i++) {
                guessedWord[i] = '*';
            }

            int misses = 0;
            boolean wordGuessed = false;

            while (!wordGuessed) {
                System.out.print("Guess a letter in the word " + new String(guessedWord) + " > ");
                char guess = input.next().charAt(0);

                boolean correctGuess = false;
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        guessedWord[i] = guess;
                        correctGuess = true;
                    }
                }

                if (!correctGuess) {
                    misses++;
                    System.out.println(guess + " is not in the word.");
                }

                wordGuessed = new String(guessedWord).indexOf('*') == -1;
            }

            System.out.println("The word is " + word + ". You missed " + misses + " time(s).");
            System.out.print("Do you want to guess another word? Enter y or n > ");
            playAgain = input.next().charAt(0) == 'y';

        } while (playAgain);

        input.close();
    }
}
