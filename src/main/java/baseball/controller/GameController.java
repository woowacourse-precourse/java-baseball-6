package baseball.controller;

import baseball.model.Computer;
import baseball.model.User;

public class GameController {
    private int strike;
    private int ball;

    private void playGame(User user, Computer computer) {
        strike = 0;
        ball = 0;
        countStrike(user, computer);
        countBall(user, computer);
        ball -= strike;
    }

    private void countBall(User user, Computer computer) {
        for (int i = 0; i < 3; i++) {
            if (computer.hasNumber(user.getDigit(i))) {
                ball++;
            }
        }
    }

    private void countStrike(User user, Computer computer) {
        for (int i = 0; i < 3; i++) {
            if (computer.getDigit(i) == user.getDigit(i)) {
                strike++;
            }
        }
    }

    public String getGameResult(User user, Computer computer) {
        playGame(user, computer);
        if (strike != 0 && ball != 0) {
            return ball + "볼 " + strike + "스트라이크";
        }
        if (strike != 0) {
            return strike + "스트라이크";
        }
        if (ball != 0) {
            return ball + "볼";
        }
        return "낫싱";
    }
}
