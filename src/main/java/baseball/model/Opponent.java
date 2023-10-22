package baseball.model;

import java.util.List;
import java.util.stream.IntStream;

public class Opponent {

    private static final int FIRST_INDEX = 0;
    private static final int NUMBER_NOT_FOUND = -1;

    private final List<Integer> numbers;

    private Opponent(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Opponent createDefaultOpponent() {
        NumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        return new Opponent(randomNumberGenerator.generateNumbers());
    }

    public static Opponent createOpponentWithGenerator(NumberGenerator generator) {
        return new Opponent(generator.generateNumbers());
    }

    public GuessResult calculateResult(final UserNumbers userNumbers) {
        GuessResult result = GuessResult.createDefault();
        List<Integer> guessedNumbers = userNumbers.getNumbers();
        IntStream.range(FIRST_INDEX, guessedNumbers.size())
            .forEach(index -> {
                int numberIndex = numbers.indexOf(guessedNumbers.get(index));
                handleResult(numberIndex, index, result);
            });

        return result;
    }

    private void handleResult(final int numberIndex, final int index, final GuessResult result) {
        if (numberIndex == NUMBER_NOT_FOUND) {
            return;
        }

        if (numberIndex == index) {
            result.addStrikeCount();
            return;
        }

        result.addBallCount();
    }
}
