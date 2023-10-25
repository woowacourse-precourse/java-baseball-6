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


    public void startGame() {
        outputView.printStart();
        Computer computer = new Computer();

        List<Integer> userGuess = guessUser();
    }

    private List<Integer> guessUser() {
        outputView.printUserGuess();
        return inputView.readUserGuess();
    }
}
