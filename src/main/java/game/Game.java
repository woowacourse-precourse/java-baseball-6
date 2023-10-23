package game;

import camp.nextstep.edu.missionutils.Console;

import static constant.Constant.*;
import static constant.ErrorMessage.*;
import static utils.InputValidator.validateUserInput;
import static utils.InputValidator.changeToIntArray;

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

        return false;
    }

    private String getUserInput() {
        System.out.println(REQUEST_INPUT);
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

