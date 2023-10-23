package baseball.service;

import baseball.model.Computer;
import baseball.model.Player;

public class NumberBaseballService {
    private Computer computer;
    private Player player;

    public NumberBaseballService(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
    }

    public void generateComputerNumbers() {
        computer.generateNumbers();
    }

}
