package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Computer {

    private final List<Integer> secretNumbers = new ArrayList<>();

    public Computer() {
    }


    public void pickNumbers() {
        secretNumbers.clear();
        while (secretNumbers.size() < 3) {
            int newNumber = Randoms.pickNumberInRange(1, 9);
            if (secretNumbers.contains(newNumber))
                continue;
            secretNumbers.add(newNumber);
        }
    }

    public Map<String, Integer> countStrikesAndBalls(int[] guessNumbers) {
        int strikes = 0;
        int balls = 0;
        for (int idx = 0; idx < 3; idx++) {
            if (secretNumbers.get(idx) == guessNumbers[idx]) {
                strikes++;
            } else {
                if (secretNumbers.contains(guessNumbers[idx]))
                    balls++;
            }
        }
        Map<String, Integer> result = new HashMap<>();
        result.put("strikes", strikes);
        result.put("balls", balls);
        return result;
    }

}
