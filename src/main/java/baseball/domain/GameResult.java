package baseball.domain;

import java.util.List;

public class GameResult {

    private final List<TryResult> tryResults;

    public GameResult(List<TryResult> tryResults) {
        this.tryResults = tryResults;
    }

    public static GameResult from(List<TryResult> tryResults) {
        return new GameResult(tryResults);
    }

    public List<TryResult> getTryResults() {
        return tryResults;
    }

    public GameStatus checkGameWin() {
        if (isThreeStrike()) {
            return GameStatus.WIN;
        }
        return GameStatus.PLAYING;
    }

    private boolean isThreeStrike() {
        return tryResults.stream()
            .allMatch(tryResult -> tryResult == TryResult.STRIKE);
    }

    public boolean hasStrike() {
        return tryResults.contains(TryResult.STRIKE);
    }

    public boolean hasBall() {
        return tryResults.contains(TryResult.BALL);
    }

    public boolean isNothing() {
        return !tryResults.contains(TryResult.STRIKE) && !tryResults.contains(TryResult.BALL);
    }

    public int getStrikeCount() {
        return (int) tryResults.stream()
            .filter(tryResult -> tryResult == TryResult.STRIKE)
            .count();
    }

    public int getBallCount() {
        return (int) tryResults.stream()
            .filter(tryResult -> tryResult == TryResult.BALL)
            .count();
    }
}
