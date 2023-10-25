package baseball.controller;

import baseball.model.BallCount;
import baseball.model.BaseBallGame;
import baseball.model.Numbers;
import baseball.util.HintConverter;
import baseball.util.NumbersConverter;
import baseball.util.RestartOptionConverter;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private BaseBallGame game;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        boolean isRunning = true;

        while (isRunning) {
            startGame();
            repeatStage();
            isRunning = inputRestartOption();
        }
    }

    private void startGame() {
        outputView.displayGameStart();
        this.game = BaseBallGame.start();
    }

    private void repeatStage() {
        boolean correct = false;
        while (!correct) {
            Numbers input = inputNumbers();

            game.inputAndCalculateBallCount(input);
            BallCount ballCount = game.getCurrentBallCount();

            String hint = HintConverter.getHint(ballCount.strike(), ballCount.ball());
            outputView.displayHint(hint);

            correct = game.isWin();
        }
        outputView.displayGameEnd();
    }

    private boolean inputRestartOption() {
        String input = inputView.inputRestartOption();
        return RestartOptionConverter.convert(input);
    }

    private Numbers inputNumbers() {
        String input = inputView.inputNumbers();
        return NumbersConverter.convert(input);
    }
}
