package baseball.domain;

import java.util.Map;
import java.util.List;

public class Umpire {

    private final Map<Integer, Baseball> umpireBasisByPosition;
    private final Map<Integer, Baseball> umpireBasisByOrder;

    public Umpire(Map<Integer, Baseball> umpireBasisByPosition, Map<Integer, Baseball> umpireBasisByOrder) {
        this.umpireBasisByPosition = umpireBasisByPosition;
        this.umpireBasisByOrder = umpireBasisByOrder;
    }

    public static Umpire from(List<Baseball> pitchedBalls) {
        return new Umpire(Baseball.partitionBallsByPosition(pitchedBalls),
                Baseball.partitionBallsByOrder(pitchedBalls));
    }
}
