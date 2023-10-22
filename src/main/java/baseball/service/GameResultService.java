package baseball.service;

import baseball.dto.BallCountDto;
import baseball.dto.GameResultDto;

public class GameResultService {


   public GameResultDto calculateGameResult(BallCountDto ballCountDto) {
       String message = createBallCountMessage(ballCountDto.showStrike(), ballCountDto.showBall());
       return new GameResultDto(ballCountDto.showStrike() == 3, message);
   }

    private String createBallCountMessage(int strike, int ball) {
        String message = "";
        if (strike == 0 && ball == 0) {
            message = "낫싱";
            return message;
        }
        if (strike != 0 && ball != 0) {
            message = String.format("%d볼 %d스트라이크", ball, strike);
            return message;
        }
        if (strike != 0) {
            message = String.format("%d스트라이크", strike);
        }
        if (ball != 0) {
            message = String.format("%d볼", ball);
        }
        return message;

    }
}
