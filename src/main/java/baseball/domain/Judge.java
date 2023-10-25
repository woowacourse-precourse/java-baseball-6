package baseball.domain;

import java.util.List;

public class Judge {
    private int balls;
    private int strikes;

    private void initCount() {
        balls = 0;
        strikes = 0;
    }

    public void callBallOrStrike(final BaseballNumber computerNumber, final BaseballNumber userNumber) {
        initCount();
        List<Integer> targetNumbers = computerNumber.numbers();
        List<Integer> userGuess = userNumber.numbers();
        for (int i = 0; i < Constants.MAX_DIGITS; i++) {
            int digit = userGuess.get(i);
            if (digit == targetNumbers.get(i)) {
                strikes++;
            } else if (targetNumbers.contains(digit)) {
                balls++;
            }
        }
    }

    public boolean isMaxStrikes() {
        return strikes == Constants.MAX_DIGITS;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (balls > 0) {
            sb.append(balls).append("볼");
        }
        if (strikes > 0) {
            if (balls > 0) {
                sb.append(" ");
            }
            sb.append(strikes).append("스트라이크");
        }

        return sb.isEmpty() ? "낫싱" : sb.toString();
    }
}
