package baseball.controller;

import baseball.service.GameService;
import baseball.utils.Parser;
import baseball.view.GameInputView;
import baseball.view.GameOutputView;

public class GameController {

    GameService gameService = new GameService();
    Parser parser = new Parser();
    GameInputView gameInputView = new GameInputView();
    GameOutputView gameOutputView = new GameOutputView();

    public void run() throws IllegalArgumentException {
        setGame();
        playGame();
        endGame();
        retryGame();
    }

    private void setGame() {
        gameService.setGame();
    }

    private void playGame() {
        gameService.playGame();
    }

    private void endGame() {
        gameService.endGame();
    }

    private void retryGame() {
        gameOutputView.printRetryGame();
        int number = parser.parseUserInput(gameInputView.getUserInput(),1)[0];
        if (number != 1 && number != 2) {
            throw new IllegalArgumentException();
        }
        if (number == 1) {
            run();
        }
    }
}