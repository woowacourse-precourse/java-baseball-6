package baseball.controller;

import baseball.model.GameResult;
import baseball.service.BaseballService;
import baseball.util.BaseballNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseballController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BaseballNumberGenerator baseballNumberGenerator;
    private final BaseballService baseballService;

    public BaseballController(InputView inputView, OutputView outputView,
                              BaseballNumberGenerator baseballNumberGenerator, BaseballService baseballService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.baseballNumberGenerator = baseballNumberGenerator;
        this.baseballService = baseballService;
    }

    public void startBaseballGame() {
        outputView.printStartGameMessage();

        boolean continueGame = true;
        while (continueGame) {
            List<Integer> baseballNumbers = baseballNumberGenerator.generateBaseballNumbers();
            playSingleGame(baseballNumbers);
            continueGame = inputView.readContinueGame();
        }
    }

    private void playSingleGame(List<Integer> baseballNumbers) {
        GameResult gameResult;
        do {
            List<Integer> inputNumbers = inputView.readThreeInputNumbers();
            gameResult = baseballService.getGameResult(baseballNumbers, inputNumbers);
            outputView.printGameResult(gameResult);
        } while (!baseballService.isFinished(gameResult));
        outputView.printGameOverMessage();
    }
}
