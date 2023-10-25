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
        this.numbers = new ArrayList<>();
    }

    public void pickRandomNumbers() {
        while (this.numbers.size() < GUESS_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
            if (!this.numbers.contains(randomNumber)) {
                this.numbers.add(randomNumber);
            }
        }
    }

    public boolean numbersContains(int number) {
        return this.numbers.contains(number);
    }

    public int getNumberOf(int index) {
        return this.numbers.get(index);
    }
}
