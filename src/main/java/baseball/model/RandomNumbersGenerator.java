package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumbersGenerator {
    public static Numbers generate() {
        List<Number> numbers = new ArrayList<>();
        while (numbers.size() < Numbers.SIZE) {
            Number number = generateRandomNumber();
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        return new Numbers(numbers);
    }

    private static Number generateRandomNumber() {
        int number = Randoms.pickNumberInRange(Number.MINIMUM, Number.MAXIMUM);
        return new Number(number);
    }
}
