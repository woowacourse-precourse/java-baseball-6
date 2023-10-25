package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserNumberGenerator {
    private static final String ZERO = "0";
    private static final String MINUS = "-";
    private static final int REQUIRED_COUNT = 3;

    public List<Integer> generate(String input) {
        validateInput(input);
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 존재하지 않습니다.");
        }
        if (input.contains(ZERO)) {
            throw new IllegalArgumentException("0은 입력할 수 없습니다.");
        }
        if (input.contains(MINUS)) {
            throw new IllegalArgumentException("음수값은 입력할 수 없습니다.");
        }
        if (input.length() != REQUIRED_COUNT) {
            throw new IllegalArgumentException("입력되는 숫자는 3자리여야 합니다.");
        }
        if (isDuplicated(input)) {
            throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
        }
    }

    private boolean isDuplicated(String input) {
        String distincted = Arrays.stream(input.split(""))
                .distinct()
                .collect(Collectors.joining());

        return !input.equals(distincted);
    }
}
