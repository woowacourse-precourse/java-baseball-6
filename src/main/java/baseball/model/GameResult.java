package baseball.model;

public class GameResult {

    private final String result;

    public GameResult(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            this.result = GameMessage.NOTHING.getMessage();
        } else if (ball == 0) {
            this.result = strike + GameMessage.STRIKE.getMessage();
        } else if (strike == 0) {
            this.result = ball + GameMessage.BALL.getMessage();
        } else {
            this.result = ball + GameMessage.BALL.getMessage() + " " +
                    strike + GameMessage.STRIKE.getMessage();
        }
    }

    public String getResult() {
        return result;
    }
}
