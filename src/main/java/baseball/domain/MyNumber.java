package baseball.domain;

import java.util.List;

public class MyNumber {

    private List<Integer> myNumberList;
    private int strike;
    private int ball;

    public MyNumber() {
        this.strike = 0;
        this.ball = 0;
    }

    public List<Integer> getMyNumberList() {
        return myNumberList;
    }

    public void setMyNumberList(List<Integer> myNumberList) {
        this.myNumberList = myNumberList;
    }

    public void resultInit() {
        this.strike = 0;
        this.ball = 0;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void ballCount() {
        ball++;
    }

    public void strikeCount() {
        strike++;
    }

}
