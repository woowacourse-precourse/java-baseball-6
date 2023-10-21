package baseball.game;

public enum Result {
    ANSWER, NOTHING, PART, DEFAULT;

    public Result getResult(BallAndStrike ballAndStrike) {
        if (ballAndStrike.getStrike() == 3) {
            return Result.ANSWER;
        }
        if (ballAndStrike.getStrike() == 0 && ballAndStrike.getBall() == 0) {
            return Result.NOTHING;
        }
        return Result.PART;
    }
}