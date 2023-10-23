package baseball.Service;

import baseball.model.Score;
import baseball.model.TargetNumber;
import baseball.model.UserNumber;

import java.util.List;

public class GameService {

    private TargetNumber targetNumber = new TargetNumber();
    private Score score = new Score();

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
        for(int i = 0; i < 3; i++) {
            if(userNumber[i]==targetNumber[i])
                score.incStrikeCount();
        }
    }

    private void countBall(List<Integer> userNumber, List<Integer> targetNumber) {

    }


}
