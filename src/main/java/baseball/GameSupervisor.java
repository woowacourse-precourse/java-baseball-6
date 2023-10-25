package baseball;

import java.util.ArrayList;
import java.util.Set;

import static baseball.BaseballConstants.*;

public class GameSupervisor {
    private int strike;
    private int ball;

    public String evaluateResult(Set<Integer> comRandomNum, int userNum, int i) {
        return operateGameStatusMessage(comRandomNum, userNum, i);
    }
    public void resetGameStatus() {
        this.strike = 0;
        this.ball = 0;
    }


    private String operateGameStatusMessage(Set<Integer> comRandomNum, int userNum, int i) {

        GameStatus gameStatus = getStatus(comRandomNum, userNum, i);

        if (gameStatus == GameStatus.STRIKE) {
            increaseStrike();
        } else if (gameStatus == GameStatus.BALL) {
            increaseBall();
        }

        return generatorResultMessage();
    }

    private GameStatus getStatus (Set<Integer> comRandomNum, int userNum, int i) {
        if (new ArrayList<>(comRandomNum).get(i) == userNum) {
            return GameStatus.STRIKE;
        } else if (comRandomNum.contains(userNum)) {
            return GameStatus.BALL;
        }
        return GameStatus.NOTHING;
    }

    private String generatorResultMessage() {
        if (strike == THREE_COUNT) {
            return STRIKE_MESSAGE;
        } else if (strike == ZERO_COUNT && ball == ZERO_COUNT) {
            return NOTHING_MESSAGE;
        }
        return ball + STRING_BALL + " " + strike + STRING_STRIKE;
    }

    private void increaseBall() {
        ball++;
    }

    private void increaseStrike() {
        strike++;
    }

}
