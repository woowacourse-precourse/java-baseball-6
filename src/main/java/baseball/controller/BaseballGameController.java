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
            List<Integer> inputNumbers = requestNumber();
            GameResult gameResult = computerNumbers.calculateGameResult(inputNumbers);

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

    private boolean isWantStopGame() {
        outputView.areYouWantStopGame(inputView.moreGameValue(), inputView.stopGameValue());
        return inputView.isWantStopGame();
    }
}
