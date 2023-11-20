package baseball.controller;

import baseball.model.PlayAgainDecision;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameRestartController {
    public static GameRestartController instance = new GameRestartController(InputView.getInstance(), OutputView.getInstance());
    private final InputView inputView;
    private final OutputView outputView;

    public GameRestartController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public static GameRestartController getInstance() {
        return instance;
    }

    public boolean wantsRestart() {
        outputView.printEnd();
        PlayAgainDecision playAgainDecision = readPlayAgainInput();
        return playAgainDecision.isAgain();
    }

    private PlayAgainDecision readPlayAgainInput() {
        int input = inputView.readPlayAgainInput();
        return PlayAgainDecision.of(input);
    }
}
