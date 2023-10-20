package baseball.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class GameResultGenerator {
    private boolean isNothing = false;
    private int ballCount = 0;
    private int strikeCount = 0;

    public GameResultGenerator(ComputerNumber computerNumber, PlayerNumber playerNumber) {
        calculateResult(computerNumber.getNumbers(), playerNumber.getNumbers());
    }


    private void calculateResult(List<Integer> computerNumber, List<Integer> playerNumber) {
        if (computerNumber.equals(playerNumber)) {
            strikeCount = 3;
            return;
        }

        for (int i = 0; i < playerNumber.size(); i++) {
            if (computerNumber.contains(playerNumber.get(i))) {  //같은 숫자가 존재하고
                if (computerNumber.get(i).equals(playerNumber.get(i))) {  //같은 위치에 있으면
                    strikeCount++;
                    continue;
                }
                ballCount++;
            }
        }
        if ((ballCount == 0) && (strikeCount == 0)) {
            isNothing = true;
        }
    }

    public boolean isNothing() {
        return isNothing;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public boolean isThreeStrike() {
        return strikeCount == 3;
    }
}
