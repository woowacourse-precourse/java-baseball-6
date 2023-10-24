package baseball.utils;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Generator {

    public static List<Integer> makeNumbers(final int size, final int start, final int end) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            numbers.add(getUniqueNumber(numbers, start, end));
        }

        return numbers;
    }

    private static int getUniqueNumber(final List<Integer> numbers, final int start, final int end) {
        while (true) {
            int pick = Randoms.pickNumberInRange(start, end);
            if (isUnique(numbers, pick)) {
                return pick;
            }
        }
    }

    private static boolean isUnique(final List<Integer> numbers, final int pick) {
        for (Integer number : numbers) {
            if (pick == number) {
                return false;
            }
        }
        return true;
    }
}
