package baseball.domain;

public class Strike {
    private int strike;

    public Strike(int strike) {
        this.strike = strike;
    }

    public int getCount() {
        return strike;
    }

    public void increase() {
        strike++;
    }
}
