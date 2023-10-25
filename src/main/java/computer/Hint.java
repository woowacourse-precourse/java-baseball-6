package computer;

import static constants.MessageConstants.*;
import static constants.NumConstants.*;
import static constants.NumConstants.NOTHING;

public class Hint {

    /**
     * strike 갯수 Count
     * @param randomString, inputNum
     * @return strike 갯수
     */
    public int cntStrike(String randomString, String inputNum) {
        int strike = 0;
        for (int i = 0; i < INPUT_LENGTH; i++) {
            if (randomString.charAt(i) == inputNum.charAt(i)) {
                strike++;
            }
        }
        return strike;
    }

    /**
     * ball 갯수 Count
     * @param randomString, inputNum
     * @return ball 갯수
     */
    public int cntBall(String randomString, String inputNum) {
        int ball = 0;
        for (int i = 0; i < INPUT_LENGTH; i++) {
            char tmp = inputNum.charAt(i);
            if (randomString.contains(String.valueOf(tmp)) && randomString.charAt(i) != tmp) {
                ball++;
            }
        }
        return ball;
    }

    /**
     * HintMessage 출력
     * @param ball, strike
     * @return ball 갯수
     */
    public void printHintMessage(int ball, int strike) {
        if (ball == NOTHING) {
            if (strike == NOTHING) {
                System.out.println(NOTHING_MESSAGE);
            } else if (strike == SUCCESS_STRIKE) {
                System.out.println(strike + STRIKE_MESSAGE);
                System.out.println(SUCCESS_MESSAGE);
            } else {
                System.out.println(strike + STRIKE_MESSAGE);
            }
        } else {
            if (strike == NOTHING) {
                System.out.println(ball + BALL_MESSAGE);
            } else {
                System.out.println(ball + BALL_MESSAGE + " " + strike + STRIKE_MESSAGE);
            }
        }
    }

}
