package baseball.model;

public class GameResult {
    public static final String STRIKE = "스트라이크";
    public static final String BALL = "볼";
    public static final String NOTHING = "낫싱";

    private int strikeNumber;
    private int ballNumber;

    private String message;

    private GameResult(String message, int strike, int ball) {
        this.message = message;
        this.strikeNumber = strike;
        this.ballNumber = ball;
    }

    public static GameResult from(int strike, int ball) {
        StringBuilder sb = new StringBuilder();
        if (ball + strike == 0)
            sb.append(NOTHING);
        if (ball > 0) {
            sb.append(ball).append(BALL).append(" ");
        }
        if (strike > 0) {
            sb.append(strike).append(STRIKE).append(" ");
        }
        return new GameResult(sb.toString(), strike, ball);
    }

    public boolean isEnd(int numberSize) {
        return strikeNumber == numberSize;
    }

    public String getMessage() {
        return message;
    }
}
