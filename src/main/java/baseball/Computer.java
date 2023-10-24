package baseball;

import java.util.List;

public class Computer {
    private RandomNumbers randomNumbers;

    public Computer() {
    }

    public void init() {
        randomNumbers = new RandomNumbers();
    }

    public int checkBallCount(List<Integer> playerNumbers) {
        return randomNumbers.checkBallCount(playerNumbers);
    }

    public int checkStrikeCount(List<Integer> playerNumbers) {
        return randomNumbers.checkStrikeCount(playerNumbers);
    }
}