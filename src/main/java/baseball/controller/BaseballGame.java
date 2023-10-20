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
            play();
        } while (!isEnd());
    }

    public void play() {
        do {
            player.getPlayerInput();
        } while (!isAllCorrect());
    }

    public boolean isEnd() {
        return this.computer.isEnd();
    }

    public boolean isAllCorrect() {
        return this.computer.isAllCorrect();
    }
}
