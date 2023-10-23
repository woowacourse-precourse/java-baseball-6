package baseball.domain;

public class Strike {

    private int strike = 0;
    public void plusStrikeCount(){
        strike++;
    }

    public int getStrike() {
        return strike;
    }
}