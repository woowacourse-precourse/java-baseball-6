package baseball;

import java.util.List;
import java.util.Optional;

class InputMapper {

    private static final String UNKNOWN_INPUT_MESSAGE = "알 수 없는 입력값(null)입니다.";
    private static final String INVALID_NUMBER_FORMAT_MESSAGE = "숫자만 입력해주세요.";

    public static List<Integer> mapToInteger(List<String> input) {
        checkInputNonNull(input);

        return mapAll(input);
    }

    public static int mapToInt(String input) {
        checkInputNonNull(input);

        return mapEach(input);
    }

    private static void checkInputNonNull(Object input) {
        Optional.ofNullable(input)
                .orElseThrow(() -> new IllegalArgumentException(UNKNOWN_INPUT_MESSAGE));
    }

    private static List<Integer> mapAll(List<String> input) {
        return input.stream()
                .map(InputMapper::mapEach)
                .toList();
    }

    private static int mapEach(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT_MESSAGE);
        }
    }
}
