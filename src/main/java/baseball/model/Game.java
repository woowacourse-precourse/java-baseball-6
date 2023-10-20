package baseball.model;

import java.util.List;

public class Game {
    private final List<Integer> computerNumber;

    public Game() {
        this.computerNumber = new ComputerNumber().getComputerNumber();
    }
}
