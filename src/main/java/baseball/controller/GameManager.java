package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.HintResult;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameManager {
    private final InputView inputView;
    private final OutputView outputView;
    private final Computer computer;

    public GameManager() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.outputView.start();
        this.computer = new Computer();
    }

    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            List<Integer> numbers = inputView.enterNumbers();
            HintResult hintResult = computer.generateHintResult(numbers);
            outputView.printHintResult(hintResult);
            if (isSuccess(hintResult)) {
                outputView.printGameOver();
                isRunning = inputView.enterRestartOrQuit().isRunning();
            }
        }
    }

    private boolean isSuccess(HintResult hintResult) {
        return hintResult.strike() == 3;
    }
}
