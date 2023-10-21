package baseball.domain;

import java.util.List;

public class ComputerNumbers {

    private final List<Integer> numbers;

    public ComputerNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void checkPlayerNumbers(PlayerNumbers playerNumbers, int digitNumber) {
        for (int i = 0; i < digitNumber; i++) {
            playerNumbers.compareForBallCount(numbers.get(i), i);
        }
    }
}
