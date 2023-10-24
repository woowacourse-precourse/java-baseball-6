package baseball.domain;

import baseball.domain.scoringnumbers.Balls;
import baseball.domain.scoringnumbers.Strikes;
import baseball.system.SystemConstant;

public class GameScore {
    public Strikes numberOfStrikes;
    public Balls numberOfBalls;

    public GameScore(Strikes newStrikes, Balls newBalls) {
        numberOfStrikes = newStrikes;
        numberOfBalls = newBalls;
    }

    public boolean isNothing() {
        return numberOfBalls.isZero() && numberOfStrikes.isZero();
    }

    public boolean isAllStrikes() {
        return numberOfStrikes.getValue() == SystemConstant.DIGIT_SIZE;
    }
}