package baseball.domain;

import java.util.List;

public class Numbers {

    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 9;

    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
