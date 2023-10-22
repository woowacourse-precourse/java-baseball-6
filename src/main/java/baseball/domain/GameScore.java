package baseball.domain;

import baseball.domain.scoringnumbers.Balls;
import baseball.domain.scoringnumbers.Strikes;

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

    public boolean isStrikesAllOfBalls() {
        return numberOfStrikes.isStrikeAllOfBalls();
    }
}