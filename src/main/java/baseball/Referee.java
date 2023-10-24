package baseball;

import baseball.util.OutputUtil;

import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Referee {
    public Referee() {
    }

    public static Boolean isGameEnd(Score score) {
        int strike = score.getStrike();
        if (strike == 3) {
            return TRUE;
        }
        return FALSE;
    }

    public Score compare(String baseballNum, String userInputNum) {
        int strike = 0;
        int ball = 0;
        int len = userInputNum.length();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if ((i == j) && (baseballNum.charAt(i) == userInputNum.charAt(j))) {
                    strike++;
                    continue;
                }
                if ((i != j) && (baseballNum.charAt(i) == userInputNum.charAt(j))) {
                    ball++;
                    continue;
                }
            }
        }
        return new Score(strike,ball);
    }
}
