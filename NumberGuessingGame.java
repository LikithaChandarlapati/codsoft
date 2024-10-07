import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MAX_ATTEMPTS = 7; 
    private static final int RANGE_MIN = 1;    
    private static final int RANGE_MAX = 100;   

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain;

        do {
            int score = 0; 
            int numberToGuess = random.nextInt(RANGE_MAX - RANGE_MIN + 1) + RANGE_MIN;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have selected a number between " + RANGE_MIN + " and " + RANGE_MAX + ".");
            System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess the number.");

            while (attempts < MAX_ATTEMPTS && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < RANGE_MIN || userGuess > RANGE_MAX) {
                    System.out.println("Please guess a number between " + RANGE_MIN + " and " + RANGE_MAX + ".");
                    attempts--; 
                    continue;
                }

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You've guessed the correct number: " + numberToGuess);
                    hasGuessedCorrectly = true;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }

                if (!hasGuessedCorrectly) {
                    int attemptsRemaining = MAX_ATTEMPTS - attempts;
                    System.out.println("Attempts remaining: " + attemptsRemaining);
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry! You've run out of attempts. The correct number was: " + numberToGuess);
            } else {
                score = MAX_ATTEMPTS - attempts + 1; 
                System.out.println("Your score for this round: " + score);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String userResponse = scanner.next();
            playAgain = userResponse.equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("Thank you for playing! Goodbye!");
        scanner.close(); 
    }
}