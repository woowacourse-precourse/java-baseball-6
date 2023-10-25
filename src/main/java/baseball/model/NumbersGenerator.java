package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumbersGenerator {

    public List<Integer> createRandomNumbers() {
        Set<Integer> set = new HashSet<>();

        while (set.size() != 3) {
            set.add(Randoms.pickNumberInRange(1, 9));
        }

        return set.stream()
                .toList();
    }
}
