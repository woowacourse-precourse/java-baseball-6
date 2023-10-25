package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumbers {

    private static final Integer MIN_NUMBER = 1;
    private static final Integer MAX_NUMBER = 9;
    private static final Integer COUNT_NUMBER = 3;

    private final List<Integer> numbers;

    private BaseballNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean isBall(Integer number) {
        return numbers.contains(number);
    }

    public boolean isStrike(int index, Integer number) {
        return numbers.get(index).equals(number);
    }

    public static BaseballNumbers generateBaseballNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < COUNT_NUMBER) {
            int number = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        return new BaseballNumbers(numbers);
    }
}
