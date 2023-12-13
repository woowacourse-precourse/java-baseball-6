package baseball.controller;

import static baseball.domain.PlayStatus.RETRY;
import static baseball.domain.PlayStatus.getPlayStatus;

import baseball.domain.BaseballMachine;
import baseball.domain.GameManager;
import baseball.domain.PlayStatus;
import baseball.domain.UserNumber;
import baseball.util.NumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {
    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;
    private GameManager gameManager;

    public BaseballController(InputView inputView, OutputView outputView, NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        outputView.printStartMessage();
        UserNumber userNumber = UserNumber.of(inputView.readNumber());
        BaseballMachine baseballMachine = BaseballMachine.of(numberGenerator.generateRandomNumbers());
        baseballMachine.printMachineNumber();
        gameManager = GameManager.getInstance(baseballMachine, userNumber);
        while (!gameManager.hasAllStrike()) {
            printGameScore();
            userNumber.updateUserNumber(inputView.readNumber());
        }
        printGameResult(gameManager.machineStrikeCount());
    }

    public void printGameScore() {
        outputView.gameScore(gameManager.gameResult());
    }

    public void printGameResult(final int strikeCount) {
        outputView.gameResult(strikeCount);
    }

    public void retry() {
        PlayStatus playStatus = getPlayStatus(inputView.readRetry());
        if (playStatus.equals(RETRY)) {
            run();
        }
        outputView.printCloseGame();
    }
}
