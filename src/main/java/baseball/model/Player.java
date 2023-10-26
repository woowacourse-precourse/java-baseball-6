package baseball.model;

import java.util.List;

public record Player(List<Integer> playerNumber) {

    public static Player createByNumber(List<Integer> playerNumber) {
        return new Player(playerNumber);
    }

    public int getNumberByPosition(int position) {
        return playerNumber.get(position);
    }
}
