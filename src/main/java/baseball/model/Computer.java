package baseball.model;

import static baseball.util.Constant.BASEBALL_GAME_NUMBER_DIGIT;
import static baseball.util.Constant.START_INDEX;

import baseball.util.NumberGenerator;
import java.util.List;
import java.util.stream.IntStream;

public class Computer {

    private final List<Integer> numbers;

    private Computer(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Computer createWith(final NumberGenerator numberGenerator) {
        return new Computer(numberGenerator.generateNumbers());
    }

    public int countStrikes(final List<Integer> guessNumbers) {
        return (int) IntStream.range(START_INDEX.getValue(), BASEBALL_GAME_NUMBER_DIGIT.getValue())
                .filter(index -> isStrike(guessNumbers.get(index), index))
                .count();
    }

    private boolean isStrike(final int guessNumber, final int index) {
        return numbers.get(index).equals(guessNumber);
    }

    public int countBalls(final List<Integer> guessNumbers) {
        return (int) IntStream.range(START_INDEX.getValue(), BASEBALL_GAME_NUMBER_DIGIT.getValue())
                .filter(index -> isBall(guessNumbers.get(index), index))
                .count();
    }

    private boolean isBall(final int guessNumber, final int index) {
        return !numbers.get(index).equals(guessNumber) && numbers.contains(guessNumber);
    }

    public boolean isGameOver(final List<Integer> guessNumbers) {
        return numbers.equals(guessNumbers);
    }
}
