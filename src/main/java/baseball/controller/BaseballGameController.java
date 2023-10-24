package baseball.controller;

import baseball.model.TargetBaseballNumbers;
import baseball.model.GameResult;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseballGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public BaseballGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        outputView.gameStart();

        while (true) {
            matchingNumber(TargetBaseballNumbers.randomInstance());

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

            if (gameResult.isPerfectGame()) {
                outputView.goodGame(TargetBaseballNumbers.BASEBALL_NUMBER_SIZE);
                break;
            }
        }
    }

    private List<Integer> requestNumber() {
        outputView.requestNumber();
        return inputView.getPlayerNumbers();
    }

    private void verifyInputNumberSize(List<Integer> inputNumbers) {
        if (TargetBaseballNumbers.BASEBALL_NUMBER_SIZE != inputNumbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isWantStopGame() {
        outputView.areYouWantMoreGame(inputView.moreGameValue(), inputView.stopGameValue());
        return inputView.isWantStopGame();
    }
}
