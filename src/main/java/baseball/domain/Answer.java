package baseball.domain;

import java.util.List;

public class Answer {

    public static final int SIZE = 3;

    private final List<Integer> targetNumbers;

    private Answer(List<Integer> targetNumbers) {
        this.targetNumbers = targetNumbers;
    }

    public static Answer of(final List<Integer> parsedNumbers) {
        return new Answer(parsedNumbers);
    }

    public boolean contains(final int expectedNumber) {
        return targetNumbers.contains(expectedNumber);
    }

    public Integer getByIndex(final int index) {
        return targetNumbers.get(index);
    }
}
