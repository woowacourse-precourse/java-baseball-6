package baseball.controller;

import baseball.service.BaseballGameService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {
    InputView inputView = new InputView();
    BaseballGameService game = new BaseballGameService();

    public BaseballGameController() {
        displayStartMessage();
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
            displayNumberInputMessage();
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
        displayEndGameMessage();
    }

    private void displayStartMessage() {
        OutputView.startGameMessage();
    }

    private void displayNumberInputMessage() {
        OutputView.numberInputMessage();
    }


    private void displayEndGameMessage() {
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