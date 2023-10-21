package baseball.dto;

public class Score {
    private int ballCount;
    private int strikeCount;

    private Score() {
    }

    private Score(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public static ScoreBuilder builder() {
        return new ScoreBuilder();
    }

    public static class ScoreBuilder {
        private int ballCount;

        private int strikeCount;

        public ScoreBuilder ballCount(int ballCount) {
            this.ballCount = ballCount;
            return this;
        }

        public ScoreBuilder strikeCount(int strikeCount) {
            this.strikeCount = strikeCount;
            return this;
        }

        public Score build() {
            return new Score(ballCount, strikeCount);
        }
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public void increaseBallCount() {
        this.ballCount++;
    }

    public void increaseStrikeCount() {
        this.strikeCount++;
    }
}
