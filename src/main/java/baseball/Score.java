package baseball;

public class Score {
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
        return strikeCount == 3;
    }

    public String getScoreResult() {
        if (strikeCount == 0 && ballCount == 0) {
            return "낫싱";
        }
        StringBuilder sb = new StringBuilder();
        if (strikeCount > 0) {
            sb.append(strikeCount).append("스트라이크 ");
        }
        if (ballCount > 0) {
            sb.append(ballCount).append("볼");
        }
        return sb.toString();
    }
}
