package baseball;

import static baseball.PlayerView.*;

public class GameResult {
    private int ballCount;
    private int strikeCount;

    public GameResult() {
        this.ballCount = 0;
        this.strikeCount = 0;
    }

    public GameResult(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public String result() {
        StringBuilder resultBuilder = new StringBuilder();

        if (isNothing()) {
            resultBuilder.append(NOTHING);
        }
        if (ballCount > 0) {
            resultBuilder.append(ballCount).append(BALL);
        }
        if (strikeCount > 0) {
            resultBuilder.append(strikeCount).append(STRIKE);
        }
        return resultBuilder.append("\n").toString();
    }

    private boolean isNothing() {
        return ballCount == 0 && strikeCount == 0;
    }

    public boolean isWin() {
        return strikeCount == 3;
    }
}