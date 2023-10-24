package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final List<Integer> secretNumbers = new ArrayList<>();

    public Computer() {
    }


    public void pickSecretNumbers() {
        secretNumbers.clear();
        while (secretNumbers.size() < GameConstants.NUM_DIGITS) {
            int newNumber = Randoms.pickNumberInRange(GameConstants.MIN_NUMBER, GameConstants.MAX_NUMBER);
            if (!secretNumbers.contains(newNumber)) {
                secretNumbers.add(newNumber);
            }
        }
    }

    public GameResult countStrikesAndBalls(List<Integer> guessNumbers) {
        int strikes = 0;
        int balls = 0;
        for (int idx = 0; idx < GameConstants.NUM_DIGITS; idx++) {
            if (secretNumbers.get(idx).equals(guessNumbers.get(idx))) {
                strikes++;
            } else {
                if (secretNumbers.contains(guessNumbers.get(idx))) {
                    balls++;
                }
            }
        }
        return new GameResult(strikes, balls);
    }

}
