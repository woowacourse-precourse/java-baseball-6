package baseball.domain;

import java.util.List;

public class PlayerNumbers {

    private final List<Integer> playerNumbers;

    private PlayerNumbers(final List<Integer> playerNumbers) {
        this.playerNumbers = playerNumbers;
    }

    public static PlayerNumbers of(final List<Integer> playerNumbers) {
        return new PlayerNumbers(playerNumbers);
    }

    public Integer getByIndex(final int index) {
        return playerNumbers.get(index);
    }
}
