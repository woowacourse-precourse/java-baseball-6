package baseball.controller;

import baseball.service.BaseballGameService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {
    InputView inputView = new InputView();
    BaseballGameService game = new BaseballGameService();

    public BaseballGameController() {
        OutputView.startGameMessage();
    }

    public void run() {
        initGame();
        playGame();
        askToRestartGame();
    }

    private void initGame() {
        game.initDto();
    }

    private void playGame() {
        while (!game.getIsCorrectAnswer()) {
            OutputView.numberInputMessage();
            game.playGame(getUserInput());
            OutputView.gameResultMessage(game.getResultMessage());
        }
    }

    private void askToRestartGame() {
        displayWhenAnsweredCorrectMessage();
        game.restartGame(getUserInput());
        if (game.getIsRestart()) {
            run();
            return;
        }
        OutputView.endGameMessage();
    }

    private String getUserInput() {
        return inputView.getUserInput();
    }

    private void displayWhenAnsweredCorrectMessage() {
        OutputView.answeredCorrectMessage();
        OutputView.restartGameMessage();
    }
}