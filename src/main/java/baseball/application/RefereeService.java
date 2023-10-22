package baseball.application;

import baseball.dto.Inning;

public class RefereeService {
    private Inning createInning(int strike, int ball) {
        if (strike + ball == 0) {
            return Inning.ofNothing();
        }
        if (ball == 0) {
            return Inning.ofStrike(strike);
        }
        if (strike == 0) {
            return Inning.ofBall(ball);
        }
        return Inning.ofBallAndStrike(ball, strike);
    }
}
