package baseball;

import java.util.List;
import java.util.Objects;

public class GameCounter {

    public int countTotal(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int total = 0;
        for (int i = 0; i < userNumbers.size(); i++) {
            if (computerNumbers.contains(userNumbers.get(i))) {
                total += 1;
            }
        }
        return total;
    }

    public int countStrike(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int strike = 0;
        for (int i = 0; i < userNumbers.size(); i++) {
            if (Objects.equals(computerNumbers.get(i), userNumbers.get(i))) {
                strike += 1;
            }
        }
        return strike;
    }
}
