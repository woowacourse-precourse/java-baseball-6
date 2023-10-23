package baseball.domain;

import baseball.constant.Constant;
import java.util.List;

public class Baseball {
    private final int ZERO = Constant.ZERO.getConstant();
    private final int NUMBER_SIZE = Constant.NUMBER_SIZE.getConstant();

    public GameResult checkInput(List<Integer> computerNumber, List<Integer> playerNumber) {
        int countStrikes = ZERO;
        int countBalls = ZERO;

        for (int i = ZERO; i < NUMBER_SIZE; i++) {
            if (playerNumber.get(i).equals(computerNumber.get(i))) {
                countStrikes++;
            } else if (computerNumber.contains(playerNumber.get(i))) {
                countBalls++;
            }
        }

        return new GameResult(countStrikes, countBalls);
    }
}