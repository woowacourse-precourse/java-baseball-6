package baseball.model;

import java.util.List;

public class Numbers {
    private List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public GameResult compareNumbers(Numbers input) {
        int strike = 0;
        int ball = 0;

        for (int num : numbers) {
            strike += isStrike(input, num);
            ball += isBall(input, num);
        }

        return new GameResult(strike, ball);
    }

    private int isStrike(Numbers input, int num) {
        if (input.indexOf(num) == numbers.indexOf(num)) {
            return 1;
        }

        return 0;
    }

    private int isBall(Numbers input, int num) {
        if (input.indexOf(num) != numbers.indexOf(num) && input.contains(num)) {
            return 1;
        }

        return 0;
    }

    private int indexOf(int num) {
        return numbers.indexOf(num);
    }

    private boolean contains(int num) {
        return numbers.contains(num);
    }
}
