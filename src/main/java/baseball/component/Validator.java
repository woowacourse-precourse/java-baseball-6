package baseball.component;

import java.util.*;
public class Validator {

    private int strike, ball;
    private boolean noting;
    private List<Integer> target;
    private final int NUMBER_SIZE = 3;

    public Validator(List<Integer> target) {
        strike = 0;
        ball = 0;
        noting = false;
        this.target = target;
    }

    private void calculateStrike(List<Integer> numbers) {
        int strike = 0;
        for (int i = 0 ; i < NUMBER_SIZE ; i++) {
            if (numbers.get(i) == target.get(i)) {
                strike++;
            }
        }
        this.strike = strike;
    }

    /**
     * 스트라이크 갯수를 이용하여 볼의 갯수를 계산하므로 스트라이크 계산 메서드를 선 호출 해야 함.
     */
    private void calculateBall(List<Integer> numbers) {
        int ball = 0;
        for (int i = 0 ; i < NUMBER_SIZE ; i++) {
            if (target.contains(numbers.get(i))) {
                ball++;
            }
        }
        this.ball = ball - strike;
    }

    private void isNoting() {
        if (ball == 0 && strike == 0) {
            noting = true;
        }
    }
}
