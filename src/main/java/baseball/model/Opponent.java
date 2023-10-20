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
        GuessResult result = new GuessResult();
        List<Integer> guessedNumbers = userNumbers.getNumbers();
        for (int index = FIRST_INDEX; index < guessedNumbers.size(); index++) {
            int numberIndex = numbers.indexOf(guessedNumbers.get(index));
            if (numberIndex == NUMBER_NOT_FOUND) {
                continue;
            }

            if (numberIndex == index) {
                result.addStrikeCount();
                continue;
            }

            result.addBallCount();
        }
        return result;
    }
}
