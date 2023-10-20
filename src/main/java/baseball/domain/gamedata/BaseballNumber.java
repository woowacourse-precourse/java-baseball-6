package baseball.domain.gamedata;

import baseball.domain.BaseballNumberMaker;
import baseball.domain.GameResult;
import java.util.List;
import java.util.stream.Stream;

public record BaseballNumber(List<Integer> numbers) implements GameData {

    /**
     *
     * @param numbers Integer list that size is 3. Throw exception if size is not 3.
     */
    public BaseballNumber {
        validateSize(numbers);
    }

    /**
     *
     * @param numbers String that size is 3 and composed only num.
     *                Throw exception if size is not 3 or can not convert to int.
     */
    public static BaseballNumber of(String numbers) {
        validate(numbers);
        return new BaseballNumber(
                Stream.of(numbers)
                        .map(Integer::parseInt)
                        .toList()
        );
    }

    public GameResult calculateResult(BaseballNumber answer) {
        int strikeAndBall = countStrikeAndBall(answer.numbers);
        int strike = countStrike(answer.numbers);
        int ball = strikeAndBall - strike;
        return new GameResult(strike, ball);
    }

    private int countStrikeAndBall(List<Integer> answerNumbers) {
        return (int) this.numbers.stream()
                .filter(answerNumbers::contains)
                .count();
    }

    private int countStrike(List<Integer> answerNumbers) {
        return (int) this.numbers.stream()
                .filter(n -> isStrike(answerNumbers, n))
                .count();
    }

    private boolean isStrike(List<Integer> answerNumbers, Integer n) {
        return answerNumbers.get(this.numbers.indexOf(n)).equals(n);
    }

    private static void validate(String numbers) {
        validateContentType(numbers);
        validateSize(numbers);
    }

    private static void validateContentType(String numbers) {
        try {
            Integer.parseInt(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static void validateSize(String numbers) {
        if (numbers.length() != BaseballNumberMaker.COUNT) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != BaseballNumberMaker.COUNT) {
            throw new IllegalArgumentException();
        }
    }
}