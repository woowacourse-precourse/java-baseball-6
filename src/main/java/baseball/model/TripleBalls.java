package baseball.model;

import baseball.util.Constants;
import baseball.util.Util;

import java.util.ArrayList;
import java.util.List;

public class TripleBalls {
    private final List<Ball> tripleBalls;

    public TripleBalls(List<Ball> tripleBalls) {
        this.tripleBalls = tripleBalls;
    }

    public String compareTripleBalls(TripleBalls otherTripleBalls) {
        long strikeTotal = 0;
        long ballTotal = 0;

        for (Ball otherOneBall : otherTripleBalls.tripleBalls) {
            strikeTotal += getResult(GameResult.STRIKE, otherOneBall);
            ballTotal += getResult(GameResult.BALL, otherOneBall);
        }

        return Util.appendGameResult(ballTotal, strikeTotal);
    }

    public boolean hasThreeStrikes(TripleBalls registeredComputer) {
        return Util.hasSameInput(compareTripleBalls(registeredComputer), Constants.THREE_STRIKE_MESSAGE);
    }

    private long getResult(GameResult resultType, Ball otherOneBall) {
        return tripleBalls.stream()
                .filter(oneBall -> resultType == oneBall.compare(otherOneBall))
                .count();
    }

    public List<Ball> getTripleBalls() {
        return new ArrayList<>(tripleBalls);
    }
}
