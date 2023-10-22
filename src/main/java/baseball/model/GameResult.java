package baseball.model;

import baseball.model.rule.BaseBallGameRule;

public class GameResult extends BaseBallGameRule {
    private final Integer ballCount;
    private final Integer strikeCount;

    public GameResult(Hint hint) {
        this.ballCount = hint.ball();
        this.strikeCount = hint.strike();
    }

    public String getGameResultMessage() {
        if (strikeCount.equals(NO_HIT) && ballCount.equals(NO_HIT)) {
            return "낫싱";
        }
        if (strikeCount.equals(NO_HIT)) {
            return ballCount + "볼";
        }
        if (ballCount.equals(NO_HIT)) {
            return strikeCount + "스트라이크";
        }
        return ballCount + "볼"+" "+ strikeCount + "스트라이크";
    }

    public boolean isAllStrikes() {
        return !strikeCount.equals(BASEBALL_MAX_AMOUNT);
    }
}
