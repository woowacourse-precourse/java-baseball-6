package baseball.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class UniqueRandomNumberGenerator {
    /**
     * 주어진 범위 내의 고유한 난수로 이루어진 리스트를 생성합니다.
     *
     * @param startOfRange 난수 범위의 시작
     * @param endOfRange   난수 범위의 끝
     * @param digitCount   생성할 난수의 길이
     * @return 고유한 난수로 이루어진 리스트
     */
    public static List<Integer> generateUniqueRandomNumbers(int startOfRange, int endOfRange, int digitCount) {
        List<Integer> availableNumbers = new ArrayList<>();
        for (int i = startOfRange; i <= endOfRange; i++) {
            availableNumbers.add(i);
        }

        List<Integer> uniqueRandomNumbers = new ArrayList<>();
        for (int i = 0; i < digitCount; i++) {
            int randomIndex = Randoms.pickNumberInRange(0, availableNumbers.size() - 1);
            uniqueRandomNumbers.add(availableNumbers.get(randomIndex));
            availableNumbers.remove(randomIndex);
        }

        return uniqueRandomNumbers;
    }
}
