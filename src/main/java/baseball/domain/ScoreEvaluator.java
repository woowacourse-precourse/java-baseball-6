package baseball.domain;

import baseball.util.Constants;
import baseball.util.ResultPrinter;

public class ScoreEvaluator {
    public int evaluateScore(BaseballNumber userNumber, BaseballNumber computerNumber) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < Constants.NUMBER_LENGTH; i++) {
            int userDigit = userNumber.getDigit(i);
            int position = computerNumber.indexOf(userDigit);
            if (position == i) {
                strike++;
            } else if (position != -1) {
                ball++;
            }
        }
        ResultPrinter.printResult(strike, ball);
        return strike;
    }
}
