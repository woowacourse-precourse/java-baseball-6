package baseball.core;

import java.util.List;

import static baseball.constant.MessageConstant.*;
import static baseball.constant.NumberConstant.INPUT_LENGTH;

public class Core {
    public int countStrike(List<Integer> computer, List<Integer> player) {
        int strikeCount = 0;

        for (int i = 0; i < INPUT_LENGTH; i++) {
            if (computer.get(i) == player.get(i)) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

    public int countBall(List<Integer> computer, List<Integer> player) {
        int ballCount = 0;

        for (int i = 0; i < INPUT_LENGTH; i++) {
            if (player.contains(computer.get(i)) && player.get(i) != computer.get(i)) {
                ballCount++;
            }
        }

        return ballCount;
    }

    public void printBaseballResult(int strike, int ball) {
        StringBuilder result = new StringBuilder();

        if (strike == 0 && ball == 0) {
            System.out.println(NOTHING_MSG);
            return;
        }
        if (ball > 0) {
            result.append(ball).append(BALL_MSG).append(" ");
        }
        if (strike > 0) {
            result.append(strike).append(STRIKE_MSG);
        }
        System.out.println(result.toString().trim());
    }

}
