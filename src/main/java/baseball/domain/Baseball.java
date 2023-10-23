package baseball.domain;

import java.util.List;

public class Baseball {

    public GameResult checkInput(List<Integer> computerNumber, List<Integer> playerNumber) {
        int countStrikes = 0;
        int countBalls = 0;

        for (int i = 0; i < 3; i++) {
            if (playerNumber.get(i).equals(computerNumber.get(i))) {
                countStrikes++;
            } else if (computerNumber.contains(playerNumber.get(i))) {
                countBalls++;
            }
        }

        return new GameResult(countStrikes, countBalls);
    }
}