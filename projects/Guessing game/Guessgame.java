import java.util.InputMismatchException; // Import class for handling invalid input
import java.util.Random;
import java.util.Scanner;

public class GuessGame {

    // Constants for the range of numbers
    private static final int MIN = 1;
    private static final int MAX = 100;

    public static void RunGuessGame(String[] args) {
        Scanner input = new Scanner(System.in);

        // Main game loop allowing the user to play multiple times
        while (true) {
            playGame(input);
            if(!playAgain(input)) {
                //input.close(); // Close the scanner after use
                return;
            }
        }
         // Check if the user wants to play again

    }

    /**
     * Runs the game where the user has to guess the number.
     */
    private static void playGame(Scanner input) {
        Random rand = new Random();
        int randomNumber = rand.nextInt(MAX - MIN + 1) + MIN; // Generate a random number in the range [MIN, MAX]
        int guess;
        int numGuesses = 0;
        boolean correct = false;

        System.out.print("Guess a number between " + MIN + " and " + MAX + ":");

        while (!correct) {
            try {
                guess = input.nextInt(); // Read user input
                numGuesses++;

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed the number in " + numGuesses + " guesses.");
                    correct = true;
                } else if (guess < randomNumber) {
                    System.out.print("Too low, try again:"); // Hint if the guess is too low
                } else {
                    System.out.print("Too high, try again:"); // Hint if the guess is too high
                }

            } catch (InputMismatchException e) {
                // Handle the case where the input is not a valid number
                System.out.print("Invalid input. Please enter a valid number between " + MIN + " and " + MAX + ".");
                input.next(); // Clear the invalid input
            }
            catch (Exception e) {}
        }
    }

    /**
     * Asks the user if they want to play again.
     * @return true if the user wants to play again; false otherwise.
     */
    private static boolean playAgain(Scanner input) {
        System.out.print("Do you want to play again? (yes/no) : ");
        String response = input.next().trim().toLowerCase();
        // Read and normalize the user's response
        return response.equals("yes") || response.equals("y"); // Check if the user wants to continue
    }
}


