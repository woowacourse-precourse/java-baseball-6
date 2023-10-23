package baseball.controller;

import baseball.domain.BaseballNumbers;
import baseball.domain.BaseballNumbersGenerator;
import baseball.domain.ContinueOrExit;
import baseball.domain.Score;
import baseball.view.InputValidator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {
    private final BaseballNumbersGenerator baseballNumbersGenerator;
    private final InputView inputView;
    private final OutputView outputView;

    public BaseballController(BaseballNumbersGenerator baseballNumbersGenerator,
                              InputView inputView,
                              OutputView outputView) {
        this.baseballNumbersGenerator = baseballNumbersGenerator;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.startGame();
        boolean isContinue = true;
        while (isContinue) {
            play();
            outputView.endGame();
            String input = inputView.continueOrExit();
            ContinueOrExit decision = ContinueOrExit.from(input);
            isContinue = decision.isContinue();
        }
    }

    private void play() {
        BaseballNumbers computer = baseballNumbersGenerator.generate();
        boolean isStrikeOut = false;
        while (!isStrikeOut) {
            String input = inputView.inputBaseballNumber();
            InputValidator.validateBaseballNumber(input);
            BaseballNumbers player = new BaseballNumbers(input);
            Score score = computer.calculateScore(player);
            outputView.matchResult(score);
            isStrikeOut = score.isStrikeOut();
        }
    }
}
