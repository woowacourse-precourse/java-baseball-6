package baseball.model;

import java.util.List;

public class Result {

    private int strike;
    private int ball;


    public Result(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }

    public void makeResult(List<Integer> computer, List<Integer> user) {

        this.strike = 0;
        this.ball = 0;

        for (int i = 0; i < 3; i++) {
            if (user.indexOf(i) == computer.indexOf(i)) {
                this.strike += 1;
            } else if (computer.contains(user.indexOf(i))) {
                this.ball += 1;
            }
        }

    }
}
