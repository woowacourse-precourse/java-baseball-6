package baseball;

import baseball.model.Computer;
import baseball.view.OutputView;

public class Game {
    private final OutputView outputView;
    private final Computer computer;

    private Game(OutputView outputView, Computer computer) {
        this.outputView = outputView;
        this.computer = computer;
    }

    public static Game getInstance(final OutputView outputView) {
        return new Game(outputView, new Computer());
    }

    public void run() {
        computer.pickRandomNumbers();
    }

}
