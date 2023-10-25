package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private List<Integer> nums = new ArrayList<>();
    private GameResult currentResult;

    public void pickRandomNumber(int count) {
        nums.clear();
        while (nums.size() < count) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!nums.contains(randomNumber)) {
                nums.add(randomNumber);
            }
        }
    }

    public GameResult getResult(List<Integer> player) {
        validateNumbers(player);
        if (currentResult == null) {
            currentResult = new GameResult(nums, player);
            return currentResult;
        }
        currentResult.calculate(nums, player);
        return currentResult;
    }

    private void validateNumbers(List<Integer> numbers) {
        validateCount(numbers);
        validateRange(numbers);
        validateUniqueNumbers(numbers);
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != nums.size()) {
            throw new IllegalArgumentException("숫자의 개수가 다르지 않아야 합니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int num: numbers) {
            if (1 > num || num > 9) {
                throw new IllegalArgumentException("1부터 9까지의 숫자만 입력해야 합니다.");
            }
        }
    }

    private void validateUniqueNumbers(List<Integer> numbers) {
        for (int num: numbers) {
            if (Collections.frequency(numbers, num) != 1) {
                throw new IllegalArgumentException("모든 숫자가 서로 달라야 합니다.");
            }
        }
    }
}