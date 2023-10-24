package baseball.service;

import baseball.domain.Balls;
import baseball.domain.Score;
import baseball.dto.ScoreDto;
import baseball.util.Util;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Game {


    public static void play() {

        Balls answerBalls = new Balls(Util.getRandomNumber(3));

        while(true) {
            OutputView.askUserNumbers();
            String userInput = InputView.askUserNumbers();
            Util.validateUserString(userInput);
            Balls userBalls = new Balls(Util.stringToIntegerList(userInput));

            Score score = Score.create(answerBalls, userBalls);

            ScoreDto scoreDto = new ScoreDto(score.getStrike(), score.getBall());
            OutputView.printScore(scoreDto);

            if(score.isAllStrike()) {
                break;
            }
        }
    }
}
