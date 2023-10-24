package baseball.model;

import java.util.List;

public class Player {
    private final List<Integer> playerNumber;

    private Player(List<Integer> playerNumber) {
        this.playerNumber = playerNumber;
    }

    public static Player createByNumber(List<Integer> playerNumber) {
        return new Player(playerNumber);
    }

    public int getNumberByPosition(int position) {
        return playerNumber.get(position);
    }
}
