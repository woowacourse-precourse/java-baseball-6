package baseball.service;

import static baseball.enums.MessageEnum.*;

import baseball.domain.BallCount;
import baseball.dto.BallCountDto;
import baseball.dto.GameResultDto;
import baseball.enums.MessageEnum;

public class GameResultService {


    private BallCount ballCount;

   public GameResultDto calculateGameResult(BallCountDto ballCountDto) {
       ballCount = new BallCount(ballCountDto.showStrike(), ballCountDto.showBall());
       String message = createBallCountMessage();
       return new GameResultDto(ballCountDto.showStrike() == 3, message);
   }

    private String createBallCountMessage() {
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
