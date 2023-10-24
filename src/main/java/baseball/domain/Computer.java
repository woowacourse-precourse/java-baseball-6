package baseball.domain;

import static baseball.global.BaseballConstant.GUESS_NUMBER_SIZE;
import static baseball.global.BaseballConstant.MAX_RANGE;
import static baseball.global.BaseballConstant.MIN_RANGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final List<Integer> numbers;

    public Computer() {
        this.numbers = pickRandomNumbers();
    }

    private List<Integer> pickRandomNumbers() {
        List<Integer> nums = new ArrayList<>();
        while (nums.size() < GUESS_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
            if (!nums.contains(randomNumber)) {
                nums.add(randomNumber);
            }
        }
        return nums;
    }

    public boolean numbersContains(int number) {
        return this.numbers.contains(number);
    }
}
