package baseball.model;

import baseball.util.NumberGenerator;
import java.util.List;
import java.util.stream.IntStream;

public class Computer {

    private static final int FIRST_NUMBER = 0;

    private final List<Number> answerNumbers;

    private Computer(final List<Number> answerNumbers) {
        this.answerNumbers = answerNumbers;
    }

    public static Computer createFromGeneratedNumbers(final NumberGenerator generator) {
        return new Computer(generator.generate());
    }

    public int countStrikes(final List<Number> userNumbers) {
        return (int) IntStream.range(FIRST_NUMBER, userNumbers.size())
                .filter(index -> isStrike(index, userNumbers))
                .count();
    }

    private boolean isStrike(final int index, final List<Number> userNumbers) {
        return this.answerNumbers.get(index).equals(userNumbers.get(index));
    }

    public int countBalls(final List<Number> userNumbers) {
        return (int) IntStream.range(FIRST_NUMBER, userNumbers.size())
                .filter(index -> isBall(index, userNumbers))
                .count();
    }

    private boolean isBall(final int index, final List<Number> userNumbers) {
        Number number = userNumbers.get(index);
        return !isStrike(index, userNumbers) && this.answerNumbers.contains(number);
    }

    public boolean isThreeStrikes(final List<Number> userNumbers) {
        return this.answerNumbers.equals(userNumbers);
    }
}
