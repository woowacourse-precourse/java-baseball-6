package baseball.controller;

import baseball.domain.BaseballNumber;
import baseball.domain.BaseballNumbers;
import baseball.domain.BaseballNumbersGenerator;
import baseball.domain.Computer;
import baseball.domain.Score;
import baseball.view.InputValidator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;
import java.util.stream.Collectors;

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
            Computer computer = new Computer(baseballNumbersGenerator);
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
            BaseballNumbers inputNumbers = convertToNumbers(input);
            Score score = computer.getScore(inputNumbers);
            outputView.matchResult(score);
            isStrikeOut = score.isStrikeOut();
        }
    }

    private BaseballNumbers convertToNumbers(String input) {
        List<BaseballNumber> inputNumbers = input.chars()
                .mapToObj(Character::getNumericValue)
                .map(BaseballNumber::new)
                .collect(Collectors.toList());
        return new BaseballNumbers(inputNumbers);
    }
}
