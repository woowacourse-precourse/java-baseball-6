package baseball.Service;

import baseball.controller.GameController;
import baseball.domain.Score;
import baseball.domain.TargetNumber;
import baseball.domain.UserNumber;

import java.util.List;

public class GameService {

    private final TargetNumber targetNumber;
    private final Score score;
    private static final int NUMBER_SIZE = 3;

    public GameService() {
        targetNumber = new TargetNumber();
        score = new Score();
    }


    public void setGame() {
        targetNumber.setTargetNumber();
    }

    public Score playGame(UserNumber userNumber) {
        score.resetScore();
        computeScore(userNumber.getUserNumber(), targetNumber.getTargetNumber());
        return score;
    }

    private void computeScore(List<Integer> userNumber, List<Integer> targetNumber) {
        countStrike(userNumber, targetNumber);
        countBall(userNumber, targetNumber);
    }

    private void countStrike(List<Integer> userNumber, List<Integer> targetNumber) {
        for(int index = 0; index < NUMBER_SIZE; index++) {
            if(userNumber.get(index) == targetNumber.get(index))
                score.incStrikeCount();
        }
    }

    private void countBall(List<Integer> userNumber, List<Integer> targetNumber) {
        for(int i = 0; i < NUMBER_SIZE; i++) {
            for(int j = 0; j< NUMBER_SIZE; j++) {
                if(userNumber.get(i) == targetNumber.get(j) && !(i == j))
                    score.incBallCount();
            }
        }
    }


}
