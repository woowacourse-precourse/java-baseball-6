package baseball.domain;

import java.util.List;

public class Game {

    public int countStrikes(List<Integer> computerNumber, List<Integer> playerNumber) {
        int strikes = 0;
        for (int i = 0; i < 3; i++) {
            int computerDigit = computerNumber.get(i);
            int playerDigit = playerNumber.get(i);

            if (computerDigit == playerDigit) {
                strikes++;
            }
        }
        return strikes;
    }
}
