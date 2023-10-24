package baseball.util;

import baseball.Constant;
import baseball.Score;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class OutputUtil {
    public OutputUtil() {
    }

    public static void printStartGame() {
        System.out.println(Constant.START_GAME_MENT);
    }

    public static void printScore(Score score) {//카운트 세주는
        int strike = score.getStrike();
        int ball = score.getBall();
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 3) {
            System.out.println("3스트라이크");
        } else if (strike == 0) {
            System.out.printf("%d볼\n", ball);
        } else if (ball == 0) {
            System.out.printf("%d스트라이크\n", strike);
        } else {
            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
        }
    }
}
