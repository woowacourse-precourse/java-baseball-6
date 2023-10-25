package baseball.model;

public class GameResult {

    private static final String NOTING_TEXT = "낫싱";

    private Ball ball;
    private Strike strike;

    public GameResult(Integer ballCount, Integer strikeCount) {
        this.ball = new Ball(ballCount);
        this.strike = new Strike(strikeCount);
    }

    public Boolean isAnswer() {
        return strike.isFullStrike();
    }

    private Boolean isNoting() {
        return !ball.isExist() && !strike.isExist();
    }

    @Override
    public String toString() {
        if (isNoting()) {
            return NOTING_TEXT;
        }
        return String.format("%s %s", ball.toString(), strike.toString()).trim();
    }
}
