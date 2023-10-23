package baseball.controller;

import baseball.model.Computer;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        outputView.printGameStart();
        List<Integer> randomNumbers = Computer.createRandomNumbers();
        Computer computer = Computer.createComputerByNumber(randomNumbers);
        List<Integer> getComputerNumber = computer.getComputerNumber();
        System.out.println(getComputerNumber);
    }
}
