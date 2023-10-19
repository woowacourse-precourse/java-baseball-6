package baseball.model;

import static baseball.Constants.MAX_NUM;
import static baseball.Constants.MIN_NUM;
import static baseball.Constants.NUMBER_COUNTS;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Opponent {

    private final List<Integer> numbers;

    private Opponent(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Opponent createOpponent() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM,
            NUMBER_COUNTS);
        return new Opponent(numbers);
    }
}
