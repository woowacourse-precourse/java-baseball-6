package baseball.utils;

import baseball.enums.GameNumber;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomGameNumberGenerator {

    public List<Integer> generate() {
        Set<Integer> randomSet = new HashSet<>();

        while (randomSet.size() < GameNumber.MAX_LENGTH.getValue()) {
            randomSet.add(Randoms.pickNumberInRange(1, 9));
        }

        return new ArrayList<>(randomSet);
    }
}