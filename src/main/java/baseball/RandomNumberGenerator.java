package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {

    public static List<Integer> generateRandomNumbers(final int countToGenerate) {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < countToGenerate) {
            int pickedNumber = Randoms.pickNumberInRange(1, 9);
            addNumberWithoutDuplicates(numbers, pickedNumber);
        }
        return numbers;
    }

    private static void addNumberWithoutDuplicates(final List<Integer> numbers, final int pickedNumber) {
        if (!numbers.contains(pickedNumber)) {
            numbers.add(pickedNumber);
        }
    }
}
