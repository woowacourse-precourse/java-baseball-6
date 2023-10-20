package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseballNumbers {

    private final List<Integer> numbers;

    public BaseballNumbers() {
        this.numbers = generateNumbers();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < 3) {
            int num = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(num)) numbers.add(num);
        }

        return Collections.unmodifiableList(numbers);
    }
}
