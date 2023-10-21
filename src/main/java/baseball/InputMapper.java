package baseball;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class InputMapper {

    private static final String UNKNOWN_INPUT_MESSAGE = "알 수 없는 입력값(null)입니다.";
    private static final String INVALID_NUMBER_FORMAT_MESSAGE = "숫자만 입력해주세요.";

    public static List<Integer> mapToInteger(List<String> input) {
        checkInputNonNull(input);

        return map(input);
    }

    private static void checkInputNonNull(List<String> input) {
        Optional.ofNullable(input)
                .orElseThrow(() -> new IllegalArgumentException(UNKNOWN_INPUT_MESSAGE));
    }

    private static List<Integer> map(List<String> input) {
        try {
            return input.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT_MESSAGE);
        }
    }
}
