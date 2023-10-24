package baseball.model;

import java.util.List;

import static baseball.util.Constant.RANGE_DIGIT;

public class Result {
    private Integer strike;
    private Integer ball;

    public Result(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public Integer getStrike() {
        return strike;
    }

    public Integer getBall() {
        return ball;
    }

    public void getResult(List<Integer> computerNums, List<Integer> userNums) {
        for (int i = 0; i < RANGE_DIGIT; i++) {
            if (computerNums.contains(userNums.get(i))) {
                if (computerNums.get(i).equals(userNums.get(i))) strike++;
                else ball++;
            }
        }
    }
}
