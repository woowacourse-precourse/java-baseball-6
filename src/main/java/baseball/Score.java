package baseball;

public class Score {
    public static final int WINNING_STRIKES = 3;
    private final int strikeCount;
    private final int ballCount;

    public Score(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean isThreeStrikes() {
        return strikeCount == WINNING_STRIKES;
    }

    public String getScoreResult() {
        if (strikeCount == 0 && ballCount == 0) {
            return "낫싱";
        }
        StringBuilder sb = new StringBuilder();
        if (ballCount > 0) {
            sb.append(ballCount).append("볼");
        }
        if (strikeCount > 0) {
            if (ballCount > 0) {
                sb.append(" ");
            }
            sb.append(strikeCount).append("스트라이크");
        }
        return sb.toString();
    }
}
