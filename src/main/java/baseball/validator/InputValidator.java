package baseball.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    public static void validateInputLength(final String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자만 입력 가능합니다.");
        }
    }

    public static void validateInputNumber(final String input) {
        long count = Arrays.stream(input.split(""))
                .filter(i -> i.charAt(0) < '1' || i.charAt(0) > '9')
                .count();

        if (count > 0) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    public static void validateInputStartNewGame(final String inputStartNewGame) {
        if (!"1".equals(inputStartNewGame) && !"2".equals(inputStartNewGame)) {
            throw new IllegalArgumentException("게임 재시작 여부는 숫자 1, 2만 입력 가능합니다.");
        }
    }

    public static void validateNumberDuplication(final List<Integer> inputNumbers) {
        Set<Integer> inputSet = new HashSet<>(inputNumbers);

        if (inputSet.size() != 3) {
            throw new IllegalArgumentException("중복되지 않는 3자리 숫자만 입력가능합니다.");
        }
    }
}
