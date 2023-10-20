package baseball.controller;

import baseball.model.GameResult;
import baseball.service.BaseballNumberGenerator;
import baseball.service.BaseballService;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseballController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BaseballNumberGenerator baseballNumberGenerator;
    private final BaseballService baseballService;

    public BaseballController(InputView inputView, OutputView outputView, BaseballNumberGenerator baseballNumberGenerator, BaseballService baseballService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.baseballNumberGenerator = baseballNumberGenerator;
        this.baseballService = baseballService;
    }

    public void startBaseballGame() {
        outputView.printStartGameMessage();
        List<Integer> baseballNumbers = baseballNumberGenerator.generateNumbers();
        List<Integer> inputNumbers = inputView.readThreeInputNumbers();
        GameResult gameResult = baseballService.getGameResult(baseballNumbers, inputNumbers);
        outputView.printGameResult(gameResult);
    }
}