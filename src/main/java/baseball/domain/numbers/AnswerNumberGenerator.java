package baseball.domain.numbers;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class AnswerNumberGenerator implements NumberGenerator {
    private static final int NUMBER_LOWER_BOUND = 1;
    private static final int NUMBER_UPPER_BOUND = 9;

    public List<Integer> generate(int numberSize) {
        Set<Integer> numbers = new HashSet<>();

        while (numbers.size() < numberSize) {
            int number = Randoms.pickNumberInRange(NUMBER_LOWER_BOUND, NUMBER_UPPER_BOUND);
            numbers.add(number);
        }
        return new ArrayList<>(numbers);
    }
}