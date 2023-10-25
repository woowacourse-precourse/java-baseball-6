package baseball.domain;

import static baseball.util.Constants.MAX_INPUT_LENGTH;

import java.util.List;
import java.util.Objects;

public class Referee {
    private int ball;
    private int strike;

    public Referee() {
        this.ball = 0;
        this.strike = 0;
    }

    public void reset() {
        this.ball = 0;
        this.strike = 0;
    }

    public void checkStrikeAndBall(List<Integer> computerNums, List<Integer> playerNums) {
        checkStrike(computerNums, playerNums);
        checkBall(computerNums, playerNums);
    }

    private void checkStrike(List<Integer> computerNums, List<Integer> playerNums) {
        for (int i = 0; i < MAX_INPUT_LENGTH; i++) {
            if (Objects.equals(computerNums.get(i), playerNums.get(i))) {
                increaseStrike();
            }
        }
    }

    private void checkBall(List<Integer> computerNums, List<Integer> playerNums) {
        for (int i = 0; i < MAX_INPUT_LENGTH; i++) {
            if (computerNums.contains(playerNums.get(i)) && !Objects.equals(computerNums.get(i), playerNums.get(i))) {
                increaseBall();
            }
        }
    }
    
    private void increaseStrike() {
        this.strike++;
    }

    private void increaseBall() {
        this.ball++;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
