package baseball.game;

import static baseball.status.GameMsg.BALL;
import static baseball.status.GameMsg.BALL_AND_STRIKE;
import static baseball.status.GameMsg.NOTHING;
import static baseball.status.GameMsg.STRIKE;

public class GameOutput {

    public void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * 볼, 스트라이크, 낫싱 출력 메시지 생성
     *
     * @param result [볼, 스트라이크]
     */
    public void output(int[] result) {
        int ball = result[0];
        int strike = result[1];

        if (strike > 0 && ball == 0) {
            printMessage(STRIKE.getMsg().formatted(strike));
        }

        if (strike == 0 && ball > 0) {
            printMessage(BALL.getMsg().formatted(ball));
        }

        if (strike > 0 && ball > 0) {
            printMessage(BALL_AND_STRIKE.getMsg().formatted(ball, strike));
        }

        printMessage(NOTHING.getMsg());
    }
}
