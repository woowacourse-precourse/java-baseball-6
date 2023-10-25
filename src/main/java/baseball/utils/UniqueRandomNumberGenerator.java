package baseball.utils;

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
     * @return 고유한 난수로 이루어진 리스트를 반환합니다.
     */
    public static List<Integer> generateUniqueRandomNumbers(final int startOfRange,
                                                            final int endOfRange,
                                                            final int digitCount) {
        List<Integer> uniqueRandomNumbers = new ArrayList<>();
        while (uniqueRandomNumbers.size() < digitCount) {
            int randomNumber = Randoms.pickNumberInRange(startOfRange, endOfRange);
            if (!uniqueRandomNumbers.contains(randomNumber)) {
                uniqueRandomNumbers.add(randomNumber);
            }
        }

        return uniqueRandomNumbers;
    }
}
