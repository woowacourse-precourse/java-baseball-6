package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    public static List<Integer> pickNumbersInRangeWithoutDuplicates(int startRange, int endRange, int count) {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < count) {
            int randomNumber = Randoms.pickNumberInRange(startRange, endRange);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }

        numbers.sort(null);

        return numbers;
    }
}
