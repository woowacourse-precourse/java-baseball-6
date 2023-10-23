package baseball.dto;

import static baseball.enums.Message.BALL;
import static baseball.enums.Message.STRIKE;

public class Score {
    private int ballCount;
    private int strikeCount;

    private Score(ScoreBuilder builder) {
        this.ballCount = builder.ballCount;
        this.strikeCount = builder.strikeCount;
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
            return new Score(this);
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

    public String getScoreBoardMessage() {
        return (getBallCountMessage() + " " + getStrikeCountMessage());
    }

    public String getBallCountMessage() {
        return (this.getBallCount() != 0) ? this.getBallCount() + BALL.getMessage() : "";
    }

    public String getStrikeCountMessage() {
        return (this.getStrikeCount() != 0) ? this.getStrikeCount() + STRIKE.getMessage() : "";
    }

    public boolean isStrikeOut() {
        return this.strikeCount == 3;
    }

    public boolean isNothing() {
        return this.getStrikeCount() + this.getBallCount() == 0;
    }
}
