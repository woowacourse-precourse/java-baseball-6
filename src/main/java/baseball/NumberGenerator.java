package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    //Parameter(숫자의 범위, 생성할 숫자의 개수)를 받아서 맞출 숫자들을 생성하는 기능.
    public static List<Integer> makeNumbers(final int startInclusive, final int endInclusive, final int size) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            numbers.add(getUniqueNumber(numbers, startInclusive, endInclusive));
        }
        return numbers;
    }

    //유니크한 숫자를 생성해서 반환하는 기능
    private static int getUniqueNumber(List<Integer> numbers, final int startInclusive, final int endInclusive) {
        while (true) {
            int pickNumber = Randoms.pickNumberInRange(startInclusive, endInclusive);
            if (isUnique(numbers, pickNumber)) {
                return pickNumber;
            }
        }
    }

    //생성된 숫자가 유니크한지 검사하는 기능
    private static boolean isUnique(final List<Integer> numbers, final int pickNumber) {
        for (Integer number : numbers) {
            if (pickNumber == number) {
                return false;
            }
        }
        return true;
    }
}
