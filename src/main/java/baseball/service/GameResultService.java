package baseball.service;

import static baseball.enums.MessageEnum.*;

import baseball.dto.BallCountDto;
import baseball.dto.GameResultDto;
import baseball.enums.MessageEnum;

public class GameResultService {


   public GameResultDto calculateGameResult(BallCountDto ballCountDto) {
       String message = createBallCountMessage(ballCountDto.showStrike(), ballCountDto.showBall());
       return new GameResultDto(ballCountDto.showStrike() == 3, message);
   }

    private String createBallCountMessage(int strike, int ball) {
        String message = "";
        if (strike == 0 && ball == 0) {
            message = NOTHING.show();
        }
        if (ball != 0) {
            message += ball + BALL.show()+ " ";
        }
        if (strike != 0) {
            message += strike + STRIKE.show();
        }

        return message;

    }
}
