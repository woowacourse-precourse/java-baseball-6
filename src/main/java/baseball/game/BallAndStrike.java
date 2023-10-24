package baseball.game;

import java.util.List;

public class BallAndStrike {
    private Integer ball;
    private Integer strike;

    public BallAndStrike() {
        this.ball = 0;
        this.strike = 0;
    }

    public Integer getBall() {
        return this.ball;
    }

    public Integer getStrike() {
        return this.strike;
    }

    public void set(List<Integer> input, List<Integer> answer) {
        if (this.ball > 0) {
            this.ball = 0;
        }
        if (this.strike > 0) {
            this.strike = 0;
        }
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) == answer.get(i)) {
                strike++;
                continue;
            }
            if (answer.contains(input.get(i))) {
                ball++;
            }
        }
    }
}
