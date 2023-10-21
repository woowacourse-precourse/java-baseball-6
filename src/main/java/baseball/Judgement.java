package baseball;

import java.util.List;

public class Judgement {
    public static final int MAX_DIGITS = 3;
    int balls;
    int strikes;

    public void init() {
        balls = 0;
        strikes = 0;
    }

    public void callBallOrStrike(BaseballNumber computerNumber, BaseballNumber userNumber) {
        List<Integer> targetNumbers = computerNumber.numbers();
        List<Integer> userGuess = userNumber.numbers();
        for (int i = 0; i < MAX_DIGITS; i++) {
            int digit = userGuess.get(i);
            if (digit == targetNumbers.get(i)) {
                strikes++;
            } else if (targetNumbers.contains(digit)) {
                balls++;
            }
        }
    }
}
