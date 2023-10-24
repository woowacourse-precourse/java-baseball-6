package baseball.domain;

import baseball.constant.Constant;
import baseball.constant.Message;

public class GameResult {
    private final int strikes;
    private final int balls;

    private static final int INITIAL_STRIKES = Constant.ZERO.getConstant();
    private static final int INITIAL_BALLS = Constant.ZERO.getConstant();
    private final int NUMBER_SIZE = Constant.NUMBER_SIZE.getConstant();

    public static GameResult initialResult() {
        return new GameResult(INITIAL_STRIKES, INITIAL_BALLS);
    }

    public GameResult(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public boolean isGameOver() {
        return strikes == NUMBER_SIZE;
    }

    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }

    public String getFormattedResult() {
        if (strikes == INITIAL_STRIKES && balls == INITIAL_BALLS) {
            return Message.NOTHING.getMessage();
        }

        StringBuilder output = new StringBuilder();
        if (balls > INITIAL_BALLS) {
            output.append(Message.BALL.format(balls));
        }
        if (strikes > INITIAL_STRIKES) {
            output.append(Message.STRIKE.format(strikes));
        }
        return output.toString();
    }
}
