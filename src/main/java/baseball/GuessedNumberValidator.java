package baseball;

import static baseball.NumberBaseballGameConfig.BASEBALL_NUMBER_LENGTH;
import static baseball.NumberBaseballGameConfig.ERROR_DUPLICATE;
import static baseball.NumberBaseballGameConfig.ERROR_LENGTH;
import static baseball.NumberBaseballGameConfig.ERROR_TYPE;
import static baseball.TypeChecker.canConvertToInteger;

import java.util.HashSet;
import java.util.List;

public class GuessedNumberValidator implements InputValidator {

    @Override
    public void validate(String input) {
        checkType(input);
        checkLength(input);
        checkDuplicate(input);
    }

    //중복 체크
    private void checkDuplicate(String input) {
        List<Integer> guessedNumber = TypeConverter.stringToIntegerList(input);
        if (new HashSet<>(guessedNumber).size() != BASEBALL_NUMBER_LENGTH) {
            throw new IllegalArgumentException(ERROR_DUPLICATE);
        }
    }

    // 타입 확인
    private void checkType(String input) {
        if (!canConvertToInteger(input)) {
            throw new IllegalArgumentException(ERROR_TYPE);
        }
    }

    // 길이 확인
    private void checkLength(String input) {
        if (input.length() != BASEBALL_NUMBER_LENGTH) {
            throw new IllegalArgumentException(ERROR_LENGTH);
        }
    }


}
