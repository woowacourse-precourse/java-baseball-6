package baseball.domain;

public class BaseballHint {
    private final int strikes;
    private final int balls;

    public BaseballHint(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    @Override
    public String toString() {
        if (strikes == 0 && balls == 0) {
            return "낫싱\n";
        }
        if (strikes == 0) {
            return String.format("%d볼\n", balls);
        }
        if (balls == 0) {
            return String.format("%d스트라이크\n", strikes);
        }
        return String.format("%d볼 %d스트라이크\n", balls, strikes);
    }

}
