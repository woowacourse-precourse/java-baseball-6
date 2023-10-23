package baseball;

import static baseball.NumberBaseballGameConfig.BASEBALL_NUMBER_LENGTH;
import static baseball.NumberBaseballGameConfig.ERROR_DUPLICATE;
import static baseball.NumberBaseballGameConfig.ERROR_LENGTH;
import static baseball.NumberBaseballGameConfig.ERROR_TYPE;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class GuessedNumberValidator implements InputValidator {

    @Override
    public void validate(String input) {
        checkType(input);
        checkLength(input);
        checkDuplicate(input);
    }

    //중복 체크
    private static void checkDuplicate(String input) {
        List<Integer> guessdeNumber = Arrays.stream(input.split(""))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        if (new HashSet<>(guessdeNumber).size() != BASEBALL_NUMBER_LENGTH) {
            throw new IllegalArgumentException(ERROR_DUPLICATE);
        }
    }

    // 타입 확인
    private static void checkType(String input) {
        try {
            Integer.parseInt(input);
            return;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_TYPE);
        }
    }

    // 길이 확인
    private static void checkLength(String input) {
        if (input.length() != BASEBALL_NUMBER_LENGTH) {
            throw new IllegalArgumentException(ERROR_LENGTH);
        }
    }
}
