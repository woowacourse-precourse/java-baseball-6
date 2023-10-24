package baseball.domain;

public class Strike {

    private final int strike;

    public Strike(int strike) {

        this.strike = strike;
    }

    public boolean isAllStrike() {

        if(strike == 3) {
            return true;
        }
        return false;
    }

    public int getStrike() {

        return strike;
    }
}
