package baseball.model;

import java.util.List;

public class Result {

    private int strike;
    private int ball;


    public Result(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public Result makeResult(List<Integer> computer, List<Integer> user) {

        strike = 0;
        ball = 0;

        for (int i = 0; i < 3; i++) {
            if (user.indexOf(i) == computer.indexOf(i)) {
                strike += 1;
            } else if (computer.contains(user.indexOf(i))) {
                ball += 1;
            }
        }

        return new Result(strike, ball);
    }
}
