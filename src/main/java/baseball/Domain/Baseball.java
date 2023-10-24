package baseball.Domain;

import java.util.List;
import java.util.stream.IntStream;

public class Baseball {

    private final List<Integer> numbers;

    public Baseball(List<Integer> numbers) {
        validateSize(numbers); validateZero(numbers);
        this.numbers = numbers;
    }

    private static void validateZero(List<Integer> numbers) {
        for(Integer n : numbers) if(n == 0) throw new IllegalArgumentException();
    }

    private static void validateSize(List<Integer> numbers) {
        if(numbers.size() != 3) throw new IllegalArgumentException();
    }

    public BaseballScore compare(Baseball baseball) {
        int ball = countBall(baseball);
        int strike = countStrike(baseball);
        return new BaseballScore(ball, strike);
    }

    private int countBall(Baseball baseball) {
        return (int) IntStream.range(0, 3)
                .filter(i -> baseball.isBall(numbers.get(i), i))
                .count();
    }

    private int countStrike(Baseball baseball) {
        return (int) IntStream.range(0, 3)
                .filter(i -> baseball.isStrike(numbers.get(i), i))
                .count();
    }

    private boolean isStrike(int number, int index) {
        return numbers.indexOf(number) == index;
    }

    private boolean isBall(int number, int index) {
        return numbers.contains(number) && numbers.indexOf(number) != index;
    }

}
