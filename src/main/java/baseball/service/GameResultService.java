package baseball.service;

import static baseball.enums.MessageEnum.*;

import baseball.domain.BallCount;
import baseball.dto.BallCountDto;
import baseball.dto.GameResultDto;
import baseball.enums.MessageEnum;

public class GameResultService {



   public GameResultDto calculateGameResult(BallCountDto ballCountDto) {
       BallCount ballCount = new BallCount(ballCountDto.showStrike(), ballCountDto.showBall());
       String message = createBallCountMessage(ballCount);
       return new GameResultDto(ballCount.showStrike() == 3, message);
   }

    private String createBallCountMessage(BallCount ballCount) {
        StringBuilder message = new StringBuilder();
        if (ballCount.hasNothing()) {
            message.append(NOTHING.show());
        }
        if (ballCount.hasBall()) {
            message.append(ballCount.showBall());
            message.append(BALL.show());
            message.append(" ");
        }
        if (ballCount.hasStrike()) {
            message.append(ballCount.showStrike());
            message.append(STRIKE.show());
        }

        return message.toString();
    }
}
