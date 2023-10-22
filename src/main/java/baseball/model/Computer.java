package baseball.model;

import baseball.utils.RandomNumberGenerator;

import java.util.List;

public class Computer {
    private List<Integer> baseballNumbers;

    public Computer() {
        baseballNumbers = RandomNumberGenerator.generateRandomNumber();
    }
}
