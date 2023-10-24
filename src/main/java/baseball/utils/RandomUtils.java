package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RandomUtils {
    public List<Integer> getRandomNumbers(int size) {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < size) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (numbers.isEmpty() || uniqueCheck(numbers, randomNumber)) {
                numbers.add(randomNumber);
            }
        }

        return numbers;
    }

    private Boolean uniqueCheck(List<Integer> numbers, Integer number) {
        for (Integer listNumber : numbers) {
            if (Objects.equals(listNumber, number)) {
                return false;
            }
        }
        return true;
    }
}
