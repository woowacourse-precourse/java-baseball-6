package baseball.model;

import java.util.List;

public class HumanModel {
    private final List<Integer> humans;
    private int strike;
    private int ball;
    private int nothing;


    public HumanModel(List<Integer> humans) {
        this.humans = humans;
    }

    public List<Integer> getHumans() {
        return humans;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public int getNothing() {
        return nothing;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public void setNothing(int nothing) {
        this.nothing = nothing;
    }
}
