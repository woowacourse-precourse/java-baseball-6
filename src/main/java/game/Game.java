package game;

import camp.nextstep.edu.missionutils.Console;

import static constant.Constant.*;
import static constant.ErrorMessage.*;
import static utils.InputValidator.validateUserInput;
import static utils.InputValidator.changeToIntArray;
import static utils.Printer.printResult;
import static utils.Printer.printSuccess;

public class Game {

    static Computer computer;

    public static void run() {
        Game game = new Game();
        do {
            computer = new Computer();
            game.startNewGame();

        } while (game.restart());
    }

    private void startNewGame() {
        String userInput;
        do {
            userInput = getUserInput();
        } while (!playRound(userInput));
    }

    private boolean playRound(String userInput) {
        int[] userGuess = changeToIntArray(userInput);
        int strike = countStrike(userGuess);
        int ball = countContain(userGuess) - strike;
        printResult(ball, strike);

        return checkSuccess(strike);
    }

    private static boolean checkSuccess(int strike) {
        if (strike == 3) {
            printSuccess();
            return true;
        }
        return false;
    }

    private int countStrike(int[] userGuess) {
        int strike = 0;
        for (int i = 0; i < NORMAL_LENGTH; i++) {
            if (userGuess[i] == computer.getAnswer().get(i)) {
                strike++;
            }
        }
        return strike;
    }

    private int countContain(int[] userGuess) {
        int contain = 0;
        for (int i = 0; i < NORMAL_LENGTH; i++) {
            if (computer.getAnswer().contains(userGuess[i])) {
                contain++;
            }
        }
        return contain;
    }


    private String getUserInput() {
        System.out.print(REQUEST_INPUT);
        String userInput = Console.readLine();
        validateUserInput(userInput);

        return userInput;
    }

    private boolean restart() {
        System.out.println(RESTART_MESSAGE);

        String InputString = Console.readLine();
        if (InputString.equals(RESTARTING_INPUT)) {
            return true;
        } else if (InputString.equals(TERMINATING_INPUT)) {
            return false;
        }

        throw new IllegalArgumentException(wrongInput);
    }
}

