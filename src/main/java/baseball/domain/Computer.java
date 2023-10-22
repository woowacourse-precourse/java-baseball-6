package baseball.domain;

import baseball.util.BaseBallGameNumberGenerator;
import java.util.List;

public class Computer {

    private final List<Integer> numbers;

    private Computer(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Computer createDefault() {
        BaseBallGameNumberGenerator baseBallGameNumberGenerator = new BaseBallGameNumberGenerator();
        return new Computer(baseBallGameNumberGenerator.generateNumbers());
    }

    public boolean isExistNumber(final int number) {
        return numbers.contains(number);
    }

    public boolean isBall(final int guessNumber, final int index) {
        return isExistNumber(guessNumber) && numbers.get(index) != guessNumber;
    }

    public boolean isStrike(final int guessNumber, final int index) {
        return numbers.get(index) == guessNumber;
    }
}
