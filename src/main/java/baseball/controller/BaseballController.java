package baseball.controller;

import baseball.domain.Number;
import baseball.domain.RandomNumberGenerator;
import baseball.dto.ComparisonResult;
import baseball.dto.RetryDto;
import baseball.view.input.InputView;
import baseball.view.output.OutputView;

public class BaseballController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RandomNumberGenerator randomNumberGenerator = RandomNumberGenerator.create();

    public void run() {
        outputView.printStartGame();

        RetryDto retryDto;
        do {
            playGame();
            retryDto = inputView.readWhetherToTry();
        } while (retryDto.isRestart());
    }

    private void playGame() {
        Number correctAnswer = randomNumberGenerator.generate();

        ComparisonResult result;
        do {
            Number answer = readAnswer();
            result = correctAnswer.compare(answer);
            outputView.printComparisonResult(result);
        } while (!result.isRight());
    }

    private Number readAnswer() {
        int value = inputView.readNumber();
        return Number.from(value);
    }
}
