package baseball.domain;

import baseball.dto.BaseballGameResultDto;

import java.util.List;

public class Referee {
    private BaseballNumber answer;

    public void decideAnswer(BaseballNumber answer){
        this.answer = answer;
    }

    public BaseballGameResultDto judge(BaseballNumber guess){
        List<Integer> numbers = guess.getNumbers();
        int strike = getStrike(numbers);
        int ball = getBall(numbers) - strike;

        return new BaseballGameResultDto(strike, ball);
    }


    private int getBall(List<Integer> numbers) {
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            int target = numbers.get(i);
            if (answer.contain(target)) {
                ball++;
            }
        }
        return ball;
    }

    private int getStrike(List<Integer> numbers) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            int target = numbers.get(i);
            if (answer.hit(target,i)) {
                strike++;
            }
        }
        return strike;
    }
}