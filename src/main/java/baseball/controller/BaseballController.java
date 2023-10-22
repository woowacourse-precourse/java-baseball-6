package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.NumbersGenerator;
import baseball.domain.Score;
import baseball.view.InputValidator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {
    private final NumbersGenerator answerGenerator;
    private final InputView inputView;
    private final OutputView outputView;

    public BaseballController(NumbersGenerator answerGenerator,
                              InputView inputView,
                              OutputView outputView) {
        this.answerGenerator = answerGenerator;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.startGame();
        boolean isContinue = true;
        while (isContinue) {
            Computer computer = new Computer(answerGenerator);
            play(computer);
            outputView.endGame();
            String input = inputView.continueOrExit();
            InputValidator.validateContinueOrExitNumber(input);
            isContinue = inputView.isContinue(input);
        }
    }

    private void play(Computer computer) {
        boolean isStrikeOut = false;
        while (!isStrikeOut) {
            String input = inputView.inputBaseballNumber();
            InputValidator.validateBaseballNumber(input);
            Score score = computer.getScore(input);
            outputView.matchResult(score);
            isStrikeOut = score.isStrikeOut();
        }
    }
}
