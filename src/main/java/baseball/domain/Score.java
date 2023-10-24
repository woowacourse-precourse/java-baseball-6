package baseball.domain;

import baseball.constants.Constants;

public class Score {
    private int ballCount;
    private int strikeCount;

    public Score() {
        this.ballCount = 0;
        this.strikeCount = 0;
    }

    public void addBallCount() {
        this.ballCount++;
    }

    public void addStrikeCount() {
        this.strikeCount++;
    }

    public String printScore() {
        StringBuilder result = new StringBuilder();

        if (ballCount != 0) {
            result.append(ballCount + Constants.BALL);
        }
        if (ballCount != 0 && strikeCount != 0) {
            result.append(" ");
        }
        if (strikeCount != 0) {
            result.append(strikeCount + Constants.STRIKE);
        }
        if (ballCount == 0 && strikeCount == 0) {
            result.append(Constants.NOTHING);
        }

        return result.toString();
    }
}
