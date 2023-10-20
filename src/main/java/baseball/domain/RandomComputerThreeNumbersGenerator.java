package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomComputerThreeNumbersGenerator {
    private int createNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public List<Integer> createOtherThreeNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = createNumber();
            if (hasNotDuplicationNumber(numbers, randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    private boolean hasNotDuplicationNumber(List<Integer> numbers, int randomNumber) {
        for (Integer number : numbers) {
            if (number == randomNumber) {
                return false;
            }
        }
        return true;
    }
}
