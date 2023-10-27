package baseball.util;

import baseball.Score;

import static baseball.Constant.*;

public class OutputUtil {
    public OutputUtil() {
    }

    public static void printStartGame() {
        System.out.println(START_GAME_MENT);
    }

    public static void printScore(Score score) {//카운트 세주는
        int strike = score.getStrike();
        int ball = score.getBall();
        if (strike == 0 && ball == 0) {
            System.out.println(NOTHING);
        } else if (strike == 3) {
            System.out.println(ALL_STRIKE);
        } else if (strike == 0) {
            System.out.printf(ball+BALL+"\n");
        } else if (ball == 0) {
            System.out.printf(strike+STRIKE+"\n");
        } else {
            System.out.printf(ball+BALL+" "+strike+STRIKE+"\n");
        }
    }
}
