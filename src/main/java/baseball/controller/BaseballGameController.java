package baseball.controller;

import baseball.dto.GameResultDto;
import baseball.model.BaseballGame;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {
    GameResultDto gameDto = new GameResultDto();
    InputView inputView = new InputView();
    BaseballGame game = new BaseballGame(gameDto);

    public BaseballGameController() {
        displayStartMessage();
    }

    public void run() {
        game.initGame();
        while (!gameDto.getIsCorrectAnswer()) {
            displayNumberInputMessage();
            game.playGame(getUserInput());
            OutputView.gameResultMessage(gameDto.getGameResultMessage());
        }
        displayWhenAnsweredCorrectMessage();
        game.restartGame(getUserInput());
        if (gameDto.getIsRestart()) {
            run();
            return;
        }
        displayEndGameMessage();
    }

    public void displayStartMessage() {
        OutputView.startGameMessage();
    }

    public void displayNumberInputMessage() {
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
