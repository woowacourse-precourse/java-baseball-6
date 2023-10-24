package baseball.domain;

import baseball.dto.GameResultDto;

import java.util.List;

public class Referee {

    private BaseballNumber answer;

    public void decideAnswer(BaseballNumber answer) {
        this.answer = answer;
    }

    public GameResultDto judge(BaseballNumber guess) {
        List<Integer> numbers = guess.getNumbers();
        int strike = getStrike(numbers);
        int ball = getBall(numbers) - strike;

        return new GameResultDto(strike, ball);
    }

    private int getBall(List<Integer> numbers) {
        int ball = 0;
        for (int index = 0; index < 3; index++) {
            int target = numbers.get(index);
            if (answer.contain(target))
                ball++;
        }
        return ball;
    }
    private int getStrike(List<Integer> numbers) {
        int strike = 0;
        for (int index = 0; index < 3; index++) {
            int target = numbers.get(index);
            if (answer.hit(target, index))
                strike++;
        }
        return strike;
    }
}
