package baseball;

import static baseball.Constant.THREE_STRIKE;
import static baseball.GameController.victory;

import java.util.List;

public class MatchCalculator {

    public int[] checkMatch(List<Integer> computerNum, List<Integer> userNum) {
        int strikeCount = countStrike(computerNum, userNum);
        int ballCount = countBall(computerNum, userNum) - strikeCount;
        checkWin(strikeCount);
        return new int[]{strikeCount, ballCount};
    }

    private int countStrike(List<Integer> computerNum, List<Integer> userNum) {
        int count = 0;
        for (int i = 0; i < computerNum.size(); i++) {
            if (computerNum.get(i).equals(userNum.get(i))) {
                count++;
            }
        }
        return count;
    }

    private int countBall(List<Integer> computerNum, List<Integer> userNum) {
        int count = 0;
        for (int i = 0; i < computerNum.size(); i++) {
            if (computerNum.contains(userNum.get(i))) {
                count++;
            }
        }
        return count;
    }

    private void checkWin(int strikeCount) {
        if (strikeCount == THREE_STRIKE) {
            victory();
        }
    }
}
