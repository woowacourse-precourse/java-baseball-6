package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberFactory {

    public static List<Integer> createNumbers(int size, int startInclusive, int endInclusive) {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < size) {
            int randomNumber = Randoms.pickNumberInRange(startInclusive, endInclusive);

            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
}
