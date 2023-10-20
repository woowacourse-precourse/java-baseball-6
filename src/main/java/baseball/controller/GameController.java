package baseball.controller;

import baseball.domain.GameNumber;
import baseball.service.NumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameController {

    private static final int NUMBER_LENGTH = 3;

    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        GameNumber computerNumber = setGame();
        System.out.println(computerNumber.getNumber());
    }

    private GameNumber setGame() {
        outputView.printStartMessage();
        List<Integer> generatedNumber = NumberGenerator.generateNumber(NUMBER_LENGTH);
        return new GameNumber(generatedNumber);
    }
}
