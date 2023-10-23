package baseball.ui;

import baseball.game.NumberBaseballGame;
import baseball.util.GuessValidator;
import java.util.Scanner;
import camp.nextstep.edu.missionutils.Console;
public class GameUI {
    private NumberBaseballGame numberBaseballGame;
    private GuessValidator guessValidator;
    private Scanner scanner;

    public GameUI(NumberBaseballGame numberBaseballGame, GuessValidator guessValidator) {
        this.numberBaseballGame = numberBaseballGame;
        this.guessValidator = guessValidator;
        scanner = new Scanner(System.in);
    }

    public String getUserGuess() {
        String guess;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("insert different 3 number");
            guess = Console.readLine();
            if (guessValidator.isValidGuess(guess)) {
                break;
            } else {
                System.out.println("not valid input. please enter different 3 numbers");
            }
        }
        return guess;
    }

    public void displayResult(int[] result) {
        System.out.println("result: " + result[0] + " strike, " + result[1] + " ball");
    }

    public int askForRestart() {
        System.out.print("quit 2, restart 1 : ");
        int choice = scanner.nextInt();
        if (choice != 1 && choice != 2) {
            System.out.println("not valid, just 2 or 1.");
            return askForRestart();
        }
        return choice;
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
