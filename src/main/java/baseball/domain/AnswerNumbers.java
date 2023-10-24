package baseball.domain;

import java.util.List;

public class AnswerNumbers {

    public static final int SIZE = 3;

    private final List<Integer> targetNumbers;

    private AnswerNumbers(List<Integer> targetNumbers) {
        this.targetNumbers = targetNumbers;
    }

    public static AnswerNumbers of(final List<Integer> parsedNumbers) {
        return new AnswerNumbers(parsedNumbers);
    }

    public boolean contains(final int expectedNumber) {
        return targetNumbers.contains(expectedNumber);
    }

    public Integer getByIndex(final int index) {
        return targetNumbers.get(index);
    }
}
