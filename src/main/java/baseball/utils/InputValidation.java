package baseball.utils;

import static baseball.utils.Constants.EXIT_INPUT;
import static baseball.utils.Constants.MAX_INPUT_LENGTH;
import static baseball.utils.Constants.RESTART_INPUT;

import java.util.List;

public final class InputValidation {
    private final static String INVALID_INPUT_SIZE = "3자리의 숫자 입력이 아닙니다.";
    private final static String DUPLICATED_INPUT = "중복된 숫자가 입력되었습니다.";
    private final static String INVALID_INPUT_TYPE = "숫자가 아닌 값이 포함되어있습니다.";
    private final static String INVALID_INPUT_RANGE = "1부터 9사이의 숫자 입력이 아닙니다.";
    private final static String INVALID_INPUT = "재시작(1)과 종료(2)를 구분하는 수가 아닌 수가 입력되었습니다.";

    /*
    숫자 야구 게임 진행 중, 사용자의 입력에 대한 검증
    */
    public static void validateInputNumbers(List<String> input) {
        validateInputSize(input);
        validateDuplicateInputList(input);
        validateIntegerStrings(input);
    }

    public static void validateInputSize(List<String> input) {
        if (input.size() != MAX_INPUT_LENGTH) {
            throw new IllegalArgumentException(INVALID_INPUT_SIZE);
        }
    }

    public static void validateDuplicateInputList(List<String> input) {
        if (input.size() != input.stream().distinct().count()) {
            throw new IllegalArgumentException(DUPLICATED_INPUT);
        }
    }

    public static void validateIntegerStrings(List<String> input) {
        for (String number : input) {
            validateInteger(number);
            validateInputRange(number);
        }
    }

    public static void validateInteger(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_TYPE);
        }
    }

    public static void validateInputRange(String input) {
        int number = Integer.parseInt(input);
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException(INVALID_INPUT_RANGE);
        }
    }

    /*
    숫자 야구 게임이 끝난 후, 재시작과 종료를 구분하는 입력에 대한 검증
     */
    public static void validateRestartOrExitInput(String input) {
        validateInteger(input);
        validateRestartOrExitValue(input);
    }

    public static void validateRestartOrExitValue(String input) {
        if (!input.equals(RESTART_INPUT) && !input.equals(EXIT_INPUT)) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }
}
