package baseball.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class NumericValidator {
    private static final int BALL_NUMBER_LENGTH = 3;
    private static final int BALL_MIN_NUMBER = 1;
    private static final int BALL_MAX_NUMBER = 9;

    public List<Integer> validate(String inputNumber) {
        List<Integer> playerNumbers = converStringToList(inputNumber);

        if (playerNumbers.size() != BALL_NUMBER_LENGTH) {
            throw new IllegalArgumentException("잘못된 입력입니다. 자릿수 오류");
        } else if (!isDifferentNumber(playerNumbers)) {
            throw new IllegalArgumentException("잘못된 입력입니다. 중복 오류");
        } else if (!isBetween1And9(playerNumbers)) {
            throw new IllegalArgumentException("잘못된 입력입니다. 범위 오류");
        }

        return playerNumbers;
    }

    // 서로 다른 숫자인지 검사
    private boolean isDifferentNumber(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        return set.size() == BALL_NUMBER_LENGTH;
    }

    // 1 ~ 9 사이의 숫자인지 검사
    private boolean isBetween1And9(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!(number >= BALL_MIN_NUMBER && number <= BALL_MAX_NUMBER)) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> converStringToList(String inputNumber) {
        int[] intArray = Arrays.stream(inputNumber.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        return Arrays.stream(intArray).boxed().collect(Collectors.toList());
    }
}
