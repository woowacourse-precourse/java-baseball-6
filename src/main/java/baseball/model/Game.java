package baseball.model;

import java.util.List;

public class Game {
    private final List<Integer> computerNumber;
    private List<Integer> playerNumber;

    public Game() {
        this.computerNumber = new ComputerNumber().getComputerNumber();
    }

    public void setPlayerNumber(String input) {
        this.playerNumber = new PlayerNumber(input).getPlayerNumber();
    }
}
