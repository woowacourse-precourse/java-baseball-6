package baseball.model;

import baseball.view.OutputView;

import java.util.List;

public class Numbers {
    private List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public GameResult compareNumbers(Numbers input) {
        int strike = countStrike(input);
        int ball = countBall(input);

        return new GameResult(strike, ball);
    }

    private int countStrike(Numbers input) {
        int strike = 0;

        for(int num : numbers) {
            if(input.indexOf(num) == numbers.indexOf(num)) {
                strike++;
            }
        }

        return strike;
    }

    private int countBall(Numbers input) {
        int ball = 0;

        for(int num : numbers) {
            if(input.indexOf(num) != numbers.indexOf(num) && input.contains(num)) {
                ball++;
            }
        }

        return ball;
    }

    private int indexOf(int num) {
        return numbers.indexOf(num);
    }

    private boolean contains(int num) {
        return numbers.contains(num);
    }
}
