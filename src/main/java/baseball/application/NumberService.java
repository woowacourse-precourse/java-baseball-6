package baseball.application;

import baseball.domain.Hint;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class NumberService {

    public List<Integer> getRandomNumber() {
        Set<Integer> numberSet = new HashSet<>();
        while (numberSet.size() < 3) {
            numberSet.add(Randoms.pickNumberInRange(1, 9));
        }

        return new ArrayList<>(numberSet);
    }

    private static void compareNumber(List<Integer> computerNumber, List<Integer> playerNumber,
                                      Hint hint) {
        for (int i = 0; i < playerNumber.size(); i++) {
            for (int j = 0; j < computerNumber.size(); j++) {
                setHint(computerNumber, playerNumber, hint, i, j);
            }
        }
    }

    private static void setHint(List<Integer> computerNumber, List<Integer> playerNumber, Hint hint,
                                int i, int j) {
        if (Objects.equals(playerNumber.get(i), computerNumber.get(j))) {
            if (i == j) {
                hint.increaseStrike();
            } else {
                hint.increaseBall();
            }
        }
    }
}
