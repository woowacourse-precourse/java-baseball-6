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
        //TODO 2023 10 22 의미없이 2중으로 연결된 메서드를 어떻게 해결하면 좋을지 고민
    }
}