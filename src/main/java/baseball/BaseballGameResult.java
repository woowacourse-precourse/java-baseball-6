package baseball;

public class BaseballGameResult {
    private final int strike;
    private final int ball;

    public BaseballGameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public boolean isWin() {
        return strike == 3;
    }

    @Override
    public String toString() {
        StringBuilder gameResultString = new StringBuilder();

        if (ball > 0) {
            gameResultString.append(ball + "볼");
        }
        if (strike > 0) {
            if (!gameResultString.isEmpty()) {
                gameResultString.append(" ");
            }
            gameResultString.append(strike + "스트라이크");
        }
        if (gameResultString.isEmpty()) {
            gameResultString.append("낫싱");
        }

        return gameResultString.toString();
    }
}
