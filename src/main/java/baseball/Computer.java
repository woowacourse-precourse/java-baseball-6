package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Computer {

    private final List<Integer> secretNumbers = new ArrayList<>();

    public Computer() {
    }


    public void pickSecretNumbers() {
        secretNumbers.clear();
        while (secretNumbers.size() < GameConstants.NUM_DIGITS) {
            int newNumber = Randoms.pickNumberInRange(1, 9);
            if (!secretNumbers.contains(newNumber)) {
                secretNumbers.add(newNumber);
            }
        }
    }

    public Map<String, Integer> countStrikesAndBalls(List<Integer> guessNumbers) {
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
        Map<String, Integer> result = new HashMap<>();
        result.put("strikes", strikes);
        result.put("balls", balls);
        return result;
    }

}
