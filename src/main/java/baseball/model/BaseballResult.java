package baseball.model;

import static baseball.model.Constant.BALL_KOREAN;
import static baseball.model.Constant.BASEBALL_NUM_LENGTH;
import static baseball.model.Constant.BLANK_SPACE_STRING;
import static baseball.model.Constant.NOTHING_CORRECT;
import static baseball.model.Constant.STRIKE_KOREAN;

public class BaseballResult {

    private final String userNumber;
    private final String computerNumber;


    public BaseballResult(String userNumber, String computerNumber) {
        this.userNumber = userNumber;
        this.computerNumber = computerNumber;
    }


    private int getBallCount() {
        int ballCount = 0;
        for (int i = 0; i < BASEBALL_NUM_LENGTH; i++) {
            for (int j = 0; j < BASEBALL_NUM_LENGTH; j++) {
                if (i == j) {
                    continue;
                }
                if (computerNumber.charAt(i) == userNumber.charAt(j)) {
                    ballCount++;
                }
            }
        }
        return ballCount;
    }

    private int getStrikeCount() {
        int strikeCount = 0;
        for (int i = 0; i < BASEBALL_NUM_LENGTH; i++) {
            if (computerNumber.charAt(i) == userNumber.charAt(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public String baseballGameResult() {
        int strikeCount = getStrikeCount();
        int ballCount = getBallCount();
        return makeResultString(strikeCount, ballCount);
    }

    private String makeResultString(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            return NOTHING_CORRECT;
        }
        if (ballCount == 0) {
            return strikeCount + STRIKE_KOREAN;
        }
        return ballCount + BALL_KOREAN + BLANK_SPACE_STRING + strikeCount + STRIKE_KOREAN;

    }

    public boolean getIsCorrect() {
        return userNumber.equals(computerNumber);
    }

}
