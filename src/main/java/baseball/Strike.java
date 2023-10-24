package baseball;

public class Strike {
    private int strike;

    public Strike(int strike) {
        this.strike = strike;
    }

    public boolean isLessThan(int count) {
        return strike < count;
    }

    public String getResultMessage() {
        return strike + "스트라이크";
    }
}
