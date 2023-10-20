package baseball.controller;

import baseball.service.BaseballNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseballController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BaseballNumberGenerator baseballNumberGenerator;

    public BaseballController(InputView inputView, OutputView outputView, BaseballNumberGenerator baseballNumberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.baseballNumberGenerator = baseballNumberGenerator;
    }

    public void startBaseballGame() {
        outputView.printStartGameMessage();
        List<Integer> numbers = baseballNumberGenerator.generateNumbers();
        List<Integer> inputNumbers = inputView.readThreeInputNumbers();
        System.out.println("inputNumbers = " + inputNumbers);
    }
}