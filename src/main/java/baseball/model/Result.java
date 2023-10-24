package baseball.model;

import java.util.List;
import java.util.Objects;

public class Result {

    private int strike;
    private int ball;

    public Result() {
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
            if (Objects.equals(user.get(i), computer.get(i))) {
                this.strike += 1;
            } else if (computer.contains(user.get(i))) {
                this.ball += 1;
            }
        }

    }
}
