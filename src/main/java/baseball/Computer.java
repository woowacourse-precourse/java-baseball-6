package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Computer {
    private static final int DIGIT_COUNT = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private final Numbers computerNumbers;

    public Computer() {
        this.computerNumbers = new Numbers(createRandomNumbers());
    }

    public static Numbers randomNumbers() {
        return new Numbers(createRandomNumbers());
    }

    private static List<Integer> createRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < DIGIT_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return Collections.unmodifiableList(numbers);
    }
}
