package baseball.domain;

import static baseball.util.MessageConst.*;
import static baseball.util.NumberConst.NUMBER_SIZE;

public class GameResult {
    private final int strikeCount;
    private final int ballCount;

    public GameResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public static GameResult of(BallNumbers answerNumbers, BallNumbers userNumbers) {
        int ballCount = 0;
        int strikeCount = 0;
        for (int i = 0; i < NUMBER_SIZE; i++) {
            if (userNumbers.isStrike(answerNumbers, i)) {
                strikeCount++;
                continue;
            }
            if (userNumbers.isBall(answerNumbers, i)) {
                ballCount++;
            }
        }
        return new GameResult(strikeCount, ballCount);
    }

    public String createResultString() {
        StringBuilder result = new StringBuilder();
        if (ballCount == 0 && strikeCount == 0) {
            return result.append(NOTHING).toString();
        }
        if (ballCount > 0) {
            result.append(String.format("%d%s ", ballCount, BALL));
        }
        if (strikeCount > 0) {
            result.append(String.format("%d%s", strikeCount, STRIKE));
        }
        return result.toString();
    }

    public int getStrikeCount() {
        return strikeCount;
    }
}
