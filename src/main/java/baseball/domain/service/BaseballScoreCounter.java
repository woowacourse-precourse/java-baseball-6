package baseball.domain.service;

import baseball.domain.model.BaseballNumber;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class BaseballScoreCounter {
    private final BaseballNumber ComputerNumber;
    private final BaseballNumber targetNumber;

    public BaseballScoreCounter(BaseballNumber computerNumber, BaseballNumber inputNumber) {
        this.ComputerNumber = computerNumber;
        this.targetNumber = inputNumber;
    }

    public int countStrikes() {
        return (int) IntStream.range(0, targetNumber.length())
                .filter(i -> targetNumber.charAt(i) == ComputerNumber.charAt(i))
                .count();
    }

    public int countBalls() {
        return (int) IntStream.range(0, ComputerNumber.length())
                .filter(this::isBall)
                .count();
    }

    private boolean isBall(int i) {
        return targetNumber.indexOf(ComputerNumber.charAt(i)) != -1
                && targetNumber.charAt(i) != ComputerNumber.charAt(i);
    }


}

