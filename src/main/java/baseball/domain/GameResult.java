package baseball.domain;

import static baseball.domain.TryResult.BALL;
import static baseball.domain.TryResult.STRIKE;

import java.util.List;

public class GameResult {

    private final List<TryResult> tryResults;

    private GameResult(List<TryResult> tryResults) {
        this.tryResults = tryResults;
    }

    public static GameResult from(List<TryResult> tryResults) {
        return new GameResult(tryResults);
    }

    public List<TryResult> getTryResults() {
        return tryResults;
    }

    public boolean isAllStrike() {
        return tryResults.stream()
            .allMatch(tryResult -> tryResult == TryResult.STRIKE);
    }

    public boolean hasResult() {
        return tryResults.contains(TryResult.STRIKE) || tryResults.contains(TryResult.BALL);
    }

    public int getCount(TryResult inputTryResult) {
        return (int) tryResults.stream()
            .filter(tryResult -> tryResult.equals(inputTryResult))
            .count();
    }

    public boolean containsStrike() {
        return tryResults.contains(STRIKE);
    }

    public boolean contains(TryResult tryResult) {
        return tryResults.contains(tryResult);
    }
}
