package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomMaker {
    public static List<Character> makeRandomNumbers() {
        List<Character> numbers = new ArrayList<>();

        while (numbers.size() < 3) {
            Character number = (char) (Randoms.pickNumberInRange(1, 9) + '0');

            if (isUniqueNumber(numbers, number)) {
                numbers.add(number);
            }
        }

        return numbers;
    }

    private static boolean isUniqueNumber(List<Character> numbers, Character number) {
        return !numbers.contains(number);
    }
}
