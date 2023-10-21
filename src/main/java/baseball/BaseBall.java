package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber {
    private RandomNumber() {}

    public static List<Integer> generate(int length) {
        List<Integer> randomNumbers = new ArrayList<>();
        if (length <= 0) {
            throw new IllegalArgumentException("길이는 1 이상이어야 합니다.");
        }
        while (randomNumbers.size() < length) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }
}
