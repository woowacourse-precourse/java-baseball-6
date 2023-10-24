package baseball.controller;

import baseball.model.Computer;
import baseball.view.GameView;

import java.util.HashSet;
import java.util.Set;

import static baseball.constant.Constant.*;
import static baseball.constant.ErrorMessage.*;

public class GameController {
    private Computer computer;
    private GameView gameView;

    public GameController() {
        this.computer = new Computer();
        this.gameView = new GameView();
    }

    public void play() {
        gameView.displayStartMessage();

        while (true) {
            String guess = gameView.getPlayerGuess();
            checkGuessNumber(guess);
            String result = computer.checkGuess(guess);
            gameView.displayResultMessage(result);

            if (result.equals(THREE_STRIKE)) {
                gameView.displaySuccessMessage();
                int restartCheck = gameView.restartCheck();

                if (restartCheck == RESTART) {
                    computer.resetNumber();
                } else if (restartCheck == EXIT) break;
                else throw new IllegalArgumentException(INVALID_RESTART_NUMBER);
            }
        }
    }

    private void checkGuessNumber(String input) {
        if (input.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException(INVALID_GUESS_NUMBER_LENGTH);
        }

        Set<Character> duplicateCheck = new HashSet<>();
        for (char ch : input.toCharArray()) {
            if (ch < '1' || ch > '9') {
                throw new IllegalArgumentException(INVALID_GUESS_NUMBER_FORMAT);
            }

            if (!duplicateCheck.add(ch)) {
                throw new IllegalArgumentException(DUPLICATED_GUESS_NUMBER);
            }
        }
    }
}