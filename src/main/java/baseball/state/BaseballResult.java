package baseball.state;

public class BaseballResultState {
    private final int MAX_MATCH = 3;
    private final int ball;
    private final int strike;
    public BaseballResultState(int _ball, int _strike) {
        if (_ball < 0 || _strike < 0 || _ball + _strike > MAX_MATCH) {
            throw new IllegalArgumentException();
        }
        ball = _ball;
        strike = _strike;
    }

    public boolean isGameEnd() {
        return strike == MAX_MATCH;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        if (ball != 0) {
            sb.append((ball + "볼"));
        }
        if (ball != 0 && strike != 0) {
            sb.append(" ");
        }
        if (strike != 0) {
            sb.append(strike + "스트라이크");
        }
        if (strike == 0 && ball == 0) {
            sb.append("낫싱");
        }
        return sb.toString();
    }
}
