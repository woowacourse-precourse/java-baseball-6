package baseball.application;

import baseball.domain.Pitch;
import baseball.dto.Inning;
import baseball.enums.GameConfig;

public class RefereeService {
    public Inning compare(Pitch player, Pitch computer) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < GameConfig.PITCH_COUNT.getValue(); i++) {
            final int playerNumber = player.get(i);
            if (computer.get(i) == playerNumber) {
                strike++;
                continue;
            }
            if (computer.contains(playerNumber)) {
                ball++;
            }
        }
        return createInning(strike, ball);
    }

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
