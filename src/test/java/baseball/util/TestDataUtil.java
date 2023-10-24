package baseball.util;

import baseball.domain.BallStatus;
import baseball.dto.GuessResult;

public class TestDataUtil {

    public static GuessResult createGuessResult(int strikeCount, int ballCount) {
        GuessResult guessResult = GuessResult.empty();

        for (int i = 0; i < strikeCount; i++) {
            guessResult.add(BallStatus.STRIKE);
        }
        for (int i = 0; i < ballCount; i++) {
            guessResult.add(BallStatus.BALL);
        }

        return guessResult;
    }

}
