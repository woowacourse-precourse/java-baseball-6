package baseball.controller;

import static baseball.domain.PlayStatus.RETRY;

import baseball.domain.BaseballMachine;
import baseball.domain.GameManager;
import baseball.domain.Judgement;
import baseball.domain.PlayStatus;
import baseball.domain.UserNumber;
import baseball.util.NumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.function.Supplier;

public class BaseballController {
    private final InputView inputView;
    private final OutputView outputView;
    private GameManager gameManager;

    public BaseballController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStartMessage();
        BaseballMachine baseballMachine = BaseballMachine.of(NumberGenerator.generateRandomNumbers());
        BaseballMachine.printMachineNumber();
        UserNumber userNumber = UserNumber.of(inputView.readNumber());
        gameManager = GameManager.getInstance(baseballMachine, userNumber);
        playBall(userNumber);
    }

    private void playBall(final UserNumber userNumber) {
        Judgement judgement = new Judgement();
        PlayStatus playStatus = RETRY;
        while (playStatus.isRetry()) {
            if (!gameManager.hasAllStrike()) {
                printGameScore(judgement);
                userNumber.updateUserNumber(inputView.readNumber());
                continue;
            }
            printGameResult(gameManager.machineStrikeCount());
            playStatus = confirmRetry(gameManager);
            judgement.updateGameStatus();
        }
    }

    private PlayStatus confirmRetry(final GameManager gameManager) {
        PlayStatus playStatus = readRetryCommand();
        if (playStatus.isRetry()) {
            gameManager.retry();
            BaseballMachine.printMachineNumber();
        }
        return playStatus;
    }

    private PlayStatus readRetryCommand() {
        return repeatBeforeSuccess(() -> PlayStatus.getPlayStatus(inputView.readPlayCommand()));
    }

    private void printGameScore(final Judgement judgement) {
        if (judgement.isNewGame()) {
            judgement.updateGameStatus();
            return;
        }
        outputView.gameScore(gameManager.gameResult());
    }

    private void printGameResult(final int strikeCount) {
        outputView.gameResult(strikeCount);
    }

    private <R> R repeatBeforeSuccess(Supplier<R> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
