package baseball.validator;

import static baseball.ConstValue.BASEBALL_MAX_LENGTH;
import static baseball.ConstValue.BASEBALL_MAX_VALUE;
import static baseball.ConstValue.BASEBALL_MIN_VALUE;
import static baseball.ConstValue.USER_ANSWER_INPUT_DIGIT_EXCEPTION;
import static baseball.ConstValue.USER_ANSWER_INPUT_ONE_TO_NINE_EXCEPTION;
import static baseball.ConstValue.USER_ANSWER_INPUT_THREE_LENGTH_EXCEPTION;
import static baseball.ConstValue.USER_ANSWER_INPUT_UNIQUE_EXCEPTION;

import java.util.HashSet;
import java.util.Set;

public class UserAnswerInputValidator implements InputValidator {

    @Override
    public void validateInput(String input) {
        // 3자리가 아닌 값 입력시 IllegalArgumentException 발생
        keepLengthThree(input);

        //숫자가 아닌경우 IllegalArgumentException 발생
        keepDigit(input);

        //숫자의 범위가 1~9이 아니면 IllegalArgumentException 발생
        keepOneToNine(input);

        //서로 다른 숫자로 구성되지 않을경우 IllegalArgumentException 발생
        keepUnique(input);
    }

    public void keepLengthThree(String input) {
        // 3자리가 아닌 값 입력시 IllegalArgumentException 발생
        if (!(input.length() == BASEBALL_MAX_LENGTH)) {
            throw new IllegalArgumentException(USER_ANSWER_INPUT_THREE_LENGTH_EXCEPTION);
        }
    }

    public void keepDigit(String input) {
        //숫자가 아닌경우 IllegalArgumentException 발생
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(USER_ANSWER_INPUT_DIGIT_EXCEPTION);
            }
        }
    }

    public void keepOneToNine(String input) {
        //숫자의 범위가 1~9이 아니면 IllegalArgumentException 발생
        for (char c : input.toCharArray()) {
            int number = Character.getNumericValue(c);
            if (!(BASEBALL_MIN_VALUE <= number && number <= BASEBALL_MAX_VALUE)) {
                throw new IllegalArgumentException(USER_ANSWER_INPUT_ONE_TO_NINE_EXCEPTION);
            }
        }
    }

    public void keepUnique(String input) {
        //서로 다른 숫자로 구성되지 않을경우 IllegalArgumentException 발생
        Set<Character> uniqueNumber = new HashSet<>();
        for (char c : input.toCharArray()) {
            uniqueNumber.add(c);
        }
        if (uniqueNumber.size() != BASEBALL_MAX_LENGTH) {
            throw new IllegalArgumentException(USER_ANSWER_INPUT_UNIQUE_EXCEPTION);
        }
    }
}
