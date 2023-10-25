package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballNumbers {
    private final List<Integer> numbers;

    public BaseballNumbers() {
        List<Integer> baseballNumbers = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!baseballNumbers.contains(randomNumber)) baseballNumbers.add(randomNumber);
        }

        this.numbers = baseballNumbers;
    }

    public boolean containNumber(int number) {
        return this.numbers.contains(number);
    }

    public boolean checkStrikeNumber(int index, int number) {
        return this.numbers.get(index) == number;
    }
}
