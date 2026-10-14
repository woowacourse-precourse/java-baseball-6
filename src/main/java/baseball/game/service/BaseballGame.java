package baseball.game.service;

import baseball.game.service.dto.Baseball;
import baseball.game.service.dto.BaseballScore;

public class BaseballGame {

    public BaseballScore match(Baseball answerBaseball, Baseball inputBaseBall) {
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
        return BaseballScore.of(ballCount, strikeCount);
    }
}
