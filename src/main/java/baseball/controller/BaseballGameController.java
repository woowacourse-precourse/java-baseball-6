package baseball.controller;

import baseball.model.TargetBaseballNumbers;
import baseball.model.GameResult;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseballGameController {
    private static final int BASEBALL_NUMBER_SIZE = 3;
    private final InputView inputView;
    private final OutputView outputView;

    public BaseballGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        outputView.gameStart();

        while (true) {
            matchingNumber(TargetBaseballNumbers.randomInstance(BASEBALL_NUMBER_SIZE));

            if (isWantStopGame()) {
                break;
            }
        }
    }

    private void matchingNumber(TargetBaseballNumbers computerNumbers) {
        while (true) {
            List<Integer> playerNumbers = requestNumber();
            verifyInputNumber(playerNumbers);
            GameResult gameResult = computerNumbers.calculateGameResult(playerNumbers);

            outputView.showGameResult(gameResult);

            if (gameResult.isPerfectGame(BASEBALL_NUMBER_SIZE)) {
                outputView.goodGame(BASEBALL_NUMBER_SIZE);
                break;
            }
        }
    }

    private List<Integer> requestNumber() {
        outputView.requestNumber();
        return inputView.getPlayerNumbers();
    }

    private void verifyInputNumber(List<Integer> inputNumberText) {
        if (BASEBALL_NUMBER_SIZE != inputNumberText.size()) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isWantStopGame() {
        outputView.areYouWantMoreGame(inputView.moreGameValue(), inputView.stopGameValue());
        return inputView.isWantStopGame();
    }
}
