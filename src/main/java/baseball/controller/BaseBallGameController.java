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
        System.out.println(game.getComputer());
        baseBallGame(game);
    }

    private Game baseBallGame(Game game) {
        inputNumber(game);
        baseBallGameService.countBall(game);
        baseBallGameService.countStrike(game);
        outputView.printResult(game);
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

    private Game initGame() {
        return new Game();
    }

    private void inputNumber(Game game) {
        baseBallGameService.inputNumberToList(game, inputView.getUserInput());
    }

}
