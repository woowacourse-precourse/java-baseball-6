package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    public static List<Integer> makeNumbers(final int startInclusive, final int endInclusive, final int size) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            numbers.add(getUniqueNumber(numbers, startInclusive, endInclusive));
        }
        return numbers;
    }

    private static int getUniqueNumber(List<Integer> numbers, final int startInclusive, final int endInclusive) {
        while (true) {
            int pickNumber = Randoms.pickNumberInRange(startInclusive, endInclusive);
            if (isUnique(numbers, pickNumber)) {
                return pickNumber;
            }
        }
    }

    private static boolean isUnique(final List<Integer> numbers, final int pickNumber) {
        for (Integer number : numbers) {
            if (pickNumber == number) {
                return false;
            }
        }
        return true;
    }
}
