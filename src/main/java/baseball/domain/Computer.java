package baseball.domain;

import baseball.global.util.RandomNumberGenerator;
import java.util.List;

public class Computer {
    private final List<Integer> numbers;

    public Computer() {
        this.numbers = RandomNumberGenerator.generateRandomNumber();
    }

}
