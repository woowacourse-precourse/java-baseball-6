package baseball.controller;

import baseball.dto.GameResultDto;
import baseball.service.BaseballGameService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {
    GameResultDto gameResultDto = new GameResultDto();
    InputView inputView = new InputView();
    BaseballGameService game = new BaseballGameService(gameResultDto);

    public BaseballGameController() {
        displayStartMessage();
    }

    public void run() {
        game.initGame();
        while (!gameResultDto.getIsCorrectAnswer()) {
            displayNumberInputMessage();
            game.playGame(getUserInput());
            OutputView.gameResultMessage(gameResultDto.getGameResultMessage());
        }
        displayWhenAnsweredCorrectMessage();
        game.restartGame(getUserInput());
        if (gameResultDto.getIsRestart()) {
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
