package baseball.model;

import java.util.List;

public class Player {
    private final List<Integer> playerNumber;

    private Player(List<Integer> playerNumber) {
        this.playerNumber = playerNumber;
    }

    public static Player createNyNumber(List<Integer> playerNumber) {
        return new Player(playerNumber);
    }

    public int getNumberByPosition(int index) {
        return playerNumber.get(index);
    }
}
