package baseball.domain.computer;

import static baseball.domain.computer.BallAndStrike.*;

import java.util.ArrayList;
import java.util.List;

public class BallAndStrikeResult {

    private final List<BallAndStrike> result = new ArrayList<>();

    public void addResult(BallAndStrike ballAndStrike) {
        result.add(ballAndStrike);
    }

    public void cleansingResult() {
        result.clear();
    }

    public int getBallCount() {
        long count = result.stream().
                filter(ballAndStrike -> ballAndStrike.equals(ball))
                .count();

        return Long.valueOf(count).intValue();
    }

    public int getStrikeCount() {
        long count = result.stream().
                filter(ballAndStrike -> ballAndStrike.equals(strike))
                .count();

        return Long.valueOf(count).intValue();
    }

}
