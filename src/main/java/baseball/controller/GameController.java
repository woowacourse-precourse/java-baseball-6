package baseball.controller;

import baseball.service.GameService;
import baseball.util.InputValidator;
import baseball.view.OutputHandler;
import camp.nextstep.edu.missionutils.Console;

public class GameController {

    private static final int RETRY = 1;
    GameService gameService = new GameService();
    InputValidator validator = new InputValidator();


    public void start() throws IllegalArgumentException {
        initGame();
        startGame();
        clearGame();
        askRetry();
    }

    private void initGame() {
        gameService.initGame();
    }

    private void startGame() {
        gameService.startGame();
    }

    private void clearGame() {
        OutputHandler.printGameClearMessage();
    }

    private void askRetry() {
        OutputHandler.askRetry();
        String retryInput = getRetryInput();
        if (!validator.validateRetryInput(retryInput)) {
            throw new IllegalArgumentException();
        }

        if (Integer.parseInt(retryInput) == RETRY) {
            start();
        }
    }

    private String getRetryInput() {
        String userInput = Console.readLine();
        if (!validator.validateHasNoChar(userInput)) {
            throw new IllegalArgumentException();
        }
        return userInput;
    }
}
