package baseball.controller;

import baseball.model.Computer;
import baseball.model.Result;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private Computer computer;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame() {
        outputView.printStart();
        computer = new Computer();
        guessUser();
    }

    public void guessUser() {
        outputView.printUserGuess();
        List<Integer> user = inputView.readUserGuess();
        Result result = computer.getStrikesAndBalls(user);
    }
}
