package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomThreeNumbersGenerator {
    private int createNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public List<Integer> createOtherThreeNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            if (hasNotDuplicationNumber(numbers)) {
                numbers.add(createNumber());
            }
        }
        return numbers;
    }

    private boolean hasNotDuplicationNumber(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        return numberSet.size() == numbers.size();
    }
}
