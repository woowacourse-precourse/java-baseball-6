package baseball.Service;

import baseball.model.Score;
import baseball.model.TargetNumber;
import baseball.model.UserNumber;

import java.util.List;

public class GameService {

    private final TargetNumber targetNumber = new TargetNumber();
    private final Score score = new Score();

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
        for(int i = 0; i < 3; i++) {
            countBall(userNumber, targetNumber, i);
        }
    }

    private void countStrike(List<Integer> userNumber, List<Integer> targetNumber) {
        for(int i = 0; i < 3; i++) {
            if(userNumber.get(i) == targetNumber.get(i))
                score.incStrikeCount();
        }
    }

    private void countBall(List<Integer> userNumber, List<Integer> targetNumber, int index) {
        for(int i = 0; i < 3; i++) {
            if(i!=index && userNumber.get(i)==targetNumber.get(index))
                score.incBallCount();
        }
    }


}
