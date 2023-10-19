package baseball.controller;

import baseball.util.RandomNumbersGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseballController {

    private final InputView inputView;
    private final OutputView outputView;

    public BaseballController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStartMessage();
        List<Integer> computer = RandomNumbersGenerator.generate();
        String guessNumber = inputView.readGuessNumber();
        System.out.println("computer = " + computer);
    }
}
