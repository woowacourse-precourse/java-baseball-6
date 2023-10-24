package baseball.service;

import java.util.List;

import baseball.domain.Balls;
import baseball.domain.Score;
import baseball.dto.ScoreDto;
import baseball.util.Util;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Game {


    public static void play() {

        List<Integer> answerNumbers = Util.getRandomNumber(3);

        while(true) {
            OutputView.askUserNumbers();
            String userInput = InputView.askUserNumbers();

            Balls balls = new Balls(userInput);

            Score score = Score.getScore(answerNumbers, balls);

            ScoreDto scoreDto = new ScoreDto(score.getStrike(), score.getBall());
            OutputView.printScore(scoreDto);

            if(score.isAllStrike()) {
                break;
            }
        }
    }
}
