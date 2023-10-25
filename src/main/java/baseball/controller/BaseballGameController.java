package baseball.controller;

import baseball.service.BaseballGameService;
import baseball.utils.DtoManager;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {
    InputView inputView = new InputView();
    DtoManager dtoManager = new DtoManager();
    BaseballGameService game = new BaseballGameService(dtoManager);

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
        while (!dtoManager.getIsCorrectAnswer()) {
            OutputView.numberInputMessage();
            game.playGame(getUserInput());
            OutputView.gameResultMessage(dtoManager.getResultMessage());
        }
    }

    private void askToRestartGame() {
        displayWhenAnsweredCorrectMessage();
        game.restartGame(getUserInput());
        if (dtoManager.getIsRestart()) {
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