package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumber {
    private final List<Integer> numbers;
    private final int MAX_LENGTH = 3;

    public RandomNumber() {
        this.numbers = new ArrayList<>();
    }

    public void randomNumberGenerator() {
        numbers.clear();
        while (numbers.size() < MAX_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
