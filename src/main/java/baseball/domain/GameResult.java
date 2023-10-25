package baseball.domain;

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

    public boolean hasResult(TryResult tryResult) {
        return tryResults.contains(tryResult);
    }

    public boolean isNothing() {
        return !tryResults.contains(TryResult.STRIKE) && !tryResults.contains(TryResult.BALL);
    }

    public int getCount(TryResult inpuTryResult) {
        return (int) tryResults.stream()
            .filter(tryResult -> tryResult.equals(inpuTryResult))
            .count();
    }
}
