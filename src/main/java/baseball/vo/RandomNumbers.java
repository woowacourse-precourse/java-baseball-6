package baseball.vo;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class RandomNumbers {
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 9;
    private List<Integer> randomNumbers;

    public RandomNumbers() {
        setRandomNumbers();
    }

    private void setRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int num = Randoms.pickNumberInRange(START_RANGE, END_RANGE);

            if (!numbers.contains(num)) {
                numbers.add(num);
            }
        }

        this.randomNumbers = numbers;
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }
}
