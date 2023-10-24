package baseball.model;

import baseball.util.BaseballAnswerGenerator;

public class Computer {

    private final int[] numbers;

    public Computer() {
        this.numbers = BaseballAnswerGenerator.generate();
    }

    public int[] getNumbers() {
        return numbers;
    }
}
