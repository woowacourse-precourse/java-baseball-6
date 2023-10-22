package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameNumbers {

    private static final int LOWER_BOUND = 1;

    private static final int UPPER_BOUND = 9;

    private static final int LENGTH = 3;

    private final List<Integer> numbers;

    private GameNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static GameNumbers create() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() != LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(LOWER_BOUND, UPPER_BOUND);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return new GameNumbers(numbers);
    }

}
