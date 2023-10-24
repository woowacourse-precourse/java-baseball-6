package baseball.utils.validator;

import baseball.exception.argument.InputLengthException;

public class InputSizeValidator {

    public static void isSame(Long source, Long target) {
        if (!source.equals(target)) {
            throw new InputLengthException();
        }
    }
}
