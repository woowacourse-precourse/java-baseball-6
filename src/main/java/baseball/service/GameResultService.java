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
        String message = "";
        if (ballCount.hasNothing()) {
            message = NOTHING.show();
        }
        if (ballCount.hasBall()) {
            message += ballCount.showBall() + BALL.show()+ " ";
        }
        if (ballCount.hasStrike()) {
            message += ballCount.showStrike() + STRIKE.show();
        }

        return message;

    }
}
