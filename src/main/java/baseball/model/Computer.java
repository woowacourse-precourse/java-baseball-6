package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Computer {
    private static final int DIGIT_COUNT = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private final Numbers numbers;

    public Computer() {
        this.numbers = createRandomUniqueNumbers();
    }

    private Numbers createRandomUniqueNumbers() {
        List<Integer> randomUniqueNumbers = new ArrayList<>();
        while (randomUniqueNumbers.size() < DIGIT_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!randomUniqueNumbers.contains(randomNumber)) {
                randomUniqueNumbers.add(randomNumber);
            }
        }
        return new Numbers(Collections.unmodifiableList(randomUniqueNumbers));
    }

    public Numbers getNumbers() {
        return numbers;
    }
}
