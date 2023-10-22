package baseball;

import java.util.List;

public class Hint {
    public int strike;
    public int ball;

    private static final int NUMBER_LEN = 3;

    public Hint() {
        this.strike = 0;
        this.ball = 0;
    }

    public void calculateHint(List<Integer> userAnswer, List<Integer> computerAnswer) {
        countStrike(userAnswer, computerAnswer);
        countBall(userAnswer, computerAnswer);
    }

    private void countStrike(List<Integer> userAnswer, List<Integer> computerAnswer) {

    }

    private void countBall(List<Integer> userAnswer, List<Integer> computerAnswer) {
 
    }
}
