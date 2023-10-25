package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberBaseball {
    private static final int NUMBER_START = 1;
    private static final int NUMBER_END = 9;
    private final List<Integer> numbers;

    public NumberBaseball(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static NumberBaseball generateRandom(int count) {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < count) {
            int number = Randoms.pickNumberInRange(NUMBER_START, NUMBER_END);
            if (!randomNumbers.contains(number)) {
                randomNumbers.add(number);
            }
        }
        return new NumberBaseball(randomNumbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
