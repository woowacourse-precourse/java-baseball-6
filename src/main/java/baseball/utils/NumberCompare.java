package baseball.utils;

import baseball.view.InputView;
import java.util.List;

public class NumberCompare {
    private int ball;
    private int strike;

    public int getStrike() {
        return strike;
    }

    public int[] getNumberCompareResult(List<Integer> playerNumber, List<Integer> computerNumber) {
        setCount();
        ballCount(playerNumber, computerNumber);
        strikeCount(playerNumber, computerNumber);
        ballSubStrike();

        return new int[]{ball, strike};
    }

    public void setCount() {
        ball = 0;
        strike = 0;
    }

    public void ballCount(List<Integer> playerNumber, List<Integer> computerNumber) {
        for (int i = 0; i < playerNumber.size(); i++) {
            if (computerNumber.contains(playerNumber.get(i))) {
                ball++;
            }
        }
    }

    public void strikeCount(List<Integer> playerNumber, List<Integer> computerNumber) {
        for (int i = 0; i < playerNumber.size(); i++) {
            if (computerNumber.get(i) == playerNumber.get(i)) {
                strike++;
            }
        }
    }

    public void ballSubStrike() {
        ball -= strike;
    }
}
