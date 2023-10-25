package baseball.controller;

import baseball.constant.ResultStatus;
import baseball.constant.RetryStatus;
import baseball.domain.AttemptNumbers;
import baseball.domain.BallCount;
import baseball.io.InputManager;
import baseball.io.OutputView;
import baseball.service.BaseballService;

public class BaseballController {

    private final OutputView outputView;
    private final InputManager inputManager;
    private final BaseballService baseballService;

    public BaseballController(
            final OutputView outputView,
            final InputManager inputManager,
            final BaseballService baseballService) {
        this.outputView = outputView;
        this.inputManager = inputManager;
        this.baseballService = baseballService;
    }

    public void run() {
        outputView.printStartMessage();
        RetryStatus retryStatus = RetryStatus.KEEP_GOING;

        while (retryStatus.isKeepGoing()) {
            baseballService.saveRandomNumbers();
            play();
            retryStatus = checkRetry();
        }
    }

    private RetryStatus checkRetry() {
        outputView.printSuccess();
        outputView.printRetryInputRequest();
        return inputManager.readRetry();
    }

    private void play() {
        ResultStatus resultStatus = ResultStatus.CONTINUE;

        while (resultStatus.isContinue()) {
            final BallCount ballCount = attempt();
            resultStatus = ballCount.checkResultStatus();
        }
    }

    private BallCount attempt() {
        outputView.printNumberInputRequest();
        final AttemptNumbers attemptNumbers = inputManager.readAttemptNumbers();
        final BallCount ballCount = baseballService.checkAnswer(attemptNumbers);
        outputView.printBallCount(ballCount);
        return ballCount;
    }
}
