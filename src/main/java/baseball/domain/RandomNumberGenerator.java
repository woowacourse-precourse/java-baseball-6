package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {
    public static List<Integer> createRandomNumbers(int count, int startNum, int endNum) {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < count) {
            int randomNumber = Randoms.pickNumberInRange(startNum, endNum);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
}
