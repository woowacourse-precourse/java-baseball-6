package baseball;


import static baseball.Constant.BASEBALL_NUM_LIMIT_LENGTH;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Referee {
    private Score score;
    public Referee() {
    }

    public static Boolean isGameEnd(Score score) {
        int strike = score.getStrike();
        if (strike == BASEBALL_NUM_LIMIT_LENGTH) {
            return TRUE;
        }
        return FALSE;
    }

    public Score judgeScore(String baseballNum, String userInputNum) {
        int len = userInputNum.length();
        score = new Score();
        for (int i = 0; i < len; i++) {
            compareIsSameNum(baseballNum, userInputNum, i);
        }
        return score;
    }

    public void compareIsSameNum(String baseballNum, String userInputNum, int index) {
        int len = userInputNum.length();
        int tmp = -1;
        for (int j = 0; j < len; j++) {
            if (baseballNum.charAt(j) == userInputNum.charAt(index)) {
                verifyScoreType(j, index);
                break;
            }
        }
    }

    public void verifyScoreType(int tmp, int index) {
        if (tmp == index) {
            score.countStrike();
            return;
        }
        score.countBall();
    }
}
