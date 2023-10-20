package baseball.controller;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.view.Output;

public class BaseballGame {
    private Computer computer;
    private Player player;

    public BaseballGame() {
        this.computer = new Computer();
        this.player = new Player();
    }

    public void startGame() {
        Output.printStart();

        do {
            computer.createRandomNumbers();
        } while (!isEnd());
    }

    public boolean isEnd() {
        return this.computer.isEnd();
    }
}
