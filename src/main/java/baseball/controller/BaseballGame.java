package baseball.controller;

import baseball.model.Computer;
import baseball.model.Player;

public class BaseballGame {
    private Computer computer;
    private Player player;

    public BaseballGame() {
        this.computer = new Computer();
        this.player = new Player();
    }
}
