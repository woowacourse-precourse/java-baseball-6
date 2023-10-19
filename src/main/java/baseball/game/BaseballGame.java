package baseball.game;

import baseball.game.dto.Baseball;
import baseball.game.dto.BaseballMatchResults;

public class BaseballGame {

    public BaseballMatchResults match(Baseball answerBaseball, Baseball inputBaseBall) {
        int length = answerBaseball.size();
        int ballCount = 0;
        int strikeCount = 0;

        for (int position = 0; position < length; position++) {
            final char value = answerBaseball.at(position);
            int inputBallSpecificValuePosition = inputBaseBall.indexOf(value);

            if (inputBallSpecificValuePosition == -1) {
                continue;
            }
            if (inputBallSpecificValuePosition == position) {
                strikeCount += 1;
                continue;
            }
            ballCount += 1;
        }
        return BaseballMatchResults.of(ballCount, strikeCount);
    }
}
