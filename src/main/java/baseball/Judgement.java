package baseball;

import java.util.List;

public class Judgement {
    int balls;
    int strikes;

    public void initCount() {
        balls = 0;
        strikes = 0;
    }

    public void callBallOrStrike(BaseballNumber computerNumber, BaseballNumber userNumber) {
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
}
