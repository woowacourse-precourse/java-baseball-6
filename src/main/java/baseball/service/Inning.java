package baseball.service;

import baseball.model.Computer;
import baseball.model.Player;

public class Inning {
    int NUMBER_SIZE = 3;
    Computer computer;
    Player player;

    public void doInning(Computer computer) {
        this.computer = computer;
        this.player = new Player();

    }

}
