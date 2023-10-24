package baseball.controller;

import baseball.model.Game;
import baseball.service.BaseBallGameService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallGameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BaseBallGameService baseBallGameService = new BaseBallGameService();

    public void startProgram() {
        outputView.startMessage();
        Game game = initGame();
        baseBallGame(game);
    }

    private Game baseBallGame(Game game) {
        inputNumber(game);
        countAndSet(game);
        outputView.printResult(game);
        return isCorrectAndRestart(game);
    }

    private Game isCorrectAndRestart(Game game) {
        if (baseBallGameService.isCorrect(game)) {
            outputView.finishMessage();
            if (inputView.getRestartInput().equals("1")) {
                return baseBallGame(initGame());
            } else {
                return null;
            }
        }
        return baseBallGame(game);
    }

    private void countAndSet(Game game) {
        baseBallGameService.countBall(game);
        baseBallGameService.countStrike(game);
    }

    private Game initGame() {
        return new Game();
    }

    private void inputNumber(Game game) {
        baseBallGameService.inputNumberToList(game, inputView.getUserInput());
    }

}
