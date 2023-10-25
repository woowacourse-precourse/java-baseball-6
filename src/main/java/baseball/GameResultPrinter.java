package baseball;

import static baseball.Application.*;

public class GameResultPrinter {
    public static void printAnswerHint() {
        strike = calculateStrikeCount();
        ball = calculateBallCount();
        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
        }
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike > 0) {
            System.out.print(strike + "스트라이크 ");
        }
        System.out.println();
    }
}
