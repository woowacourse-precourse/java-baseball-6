package baseball.number;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumber {
    int[] values = {1, 1, 1};

    private boolean validateInput(String input) {
        if (input.length() != 3) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
            int value = Character.getNumericValue(input.charAt(i));
            if (value < 1 || value > 9) {
                return false;
            }
            if (set.contains(value)) {
                return false;
            }
            set.add(value);
        }
        return true;
    }

    public BaseballNumber(String input) {
        if (!validateInput(input)) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < 3; i++) {
            this.values[i] = Character.getNumericValue(input.charAt(i));
        }
    }
    public BaseballNumber() {
        List<Integer> randomValues = new ArrayList<>();
        while (randomValues.size() < 3) {
            int randomValue = Randoms.pickNumberInRange(1, 9);
            if (!randomValues.contains(randomValue)) randomValues.add(randomValue);
        }
        for (int i = 0; i < 3; i++) {
            this.values[i] = randomValues.get(i);
        }
    }

    public int checkBall(int target) {
        int acc = 0;
        for (int value : this.values) {
            if (value == target) {
                acc++;
            }
        }
        return acc;
    }

    public BaseballResult compareTo(BaseballNumber target) {
        BaseballResult result = new BaseballResult();
        for (int i = 0; i < 3; i++) {
            if (this.values[i] == target.values[i]) {
                result.strike++;
                continue;
            }
            result.ball += checkBall(target.values[i]);
        }
        return result;
    }
}