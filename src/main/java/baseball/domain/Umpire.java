package baseball.domain;

import baseball.domain.score.BallStrikeCount;
import baseball.domain.score.ImmutableBallStrikeCount;
import java.util.Map;
import java.util.List;

public class Umpire {

    private final Map<Integer, Baseball> umpireBasisByPosition;
    private final Map<Integer, Baseball> umpireBasisByOrder;

    private Umpire(Map<Integer, Baseball> umpireBasisByPosition, Map<Integer, Baseball> umpireBasisByOrder) {
        this.umpireBasisByPosition = umpireBasisByPosition;
        this.umpireBasisByOrder = umpireBasisByOrder;
    }

    public static Umpire from(List<Baseball> pitchedBalls) {
        return new Umpire(Baseball.partitionBallsByPosition(pitchedBalls),
                Baseball.partitionBallsByOrder(pitchedBalls));
    }

    public ImmutableBallStrikeCount umpireBattedBalls(List<Baseball> battedBalls) {
        BallStrikeCount ballStrikeCount = BallStrikeCount.initial();
        battedBalls.forEach(battedBall -> umpireBattedBall(battedBall, ballStrikeCount));

        return ballStrikeCount.toImmutable();
    }

    private void umpireBattedBall(Baseball battedBall, BallStrikeCount currentCount) {
        if (battedBall.isStrike(umpireBasisByOrder)) {
            currentCount.countStrike();
            return;
        }
        if (battedBall.isBall(umpireBasisByPosition)) {
            currentCount.countBall();
        }
    }
}
