package baseball.domain;

import java.util.List;

public class MyNumber {

    private static final int STRIKE_AND_BALL_COUNT_INIT_VALUE = 0;
    private static final int STRIKE_AND_BALL_INCREASE_VALUE = 1;

    private List<Integer> myNumberList;
    private int strike;
    private int ball;

    public MyNumber() {
        this.strike = STRIKE_AND_BALL_COUNT_INIT_VALUE;
        this.ball = STRIKE_AND_BALL_COUNT_INIT_VALUE;
    }

    public List<Integer> getMyNumberList() {
        return myNumberList;
    }

    public void setMyNumberList(List<Integer> myNumberList) {
        this.myNumberList = myNumberList;
    }

    public void resultInit() {
        this.strike = STRIKE_AND_BALL_COUNT_INIT_VALUE;
        this.ball = STRIKE_AND_BALL_COUNT_INIT_VALUE;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void ballCount() {
        ball += STRIKE_AND_BALL_INCREASE_VALUE;
    }

    public void strikeCount() {
        strike += STRIKE_AND_BALL_INCREASE_VALUE;
    }

}
