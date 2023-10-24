package baseball.baseballV2.system.validator;

import baseball.baseballV2.system.util.Util;
import java.util.List;

public class TripleBallsValidator {
    public static final String NOT_THREE_DIGITS_ERROR = "세개의 숫자로 구성되어 있지 않습니다.";
    public static final String DUPLICATED_NUMBER_ERROR = "중복된 숫자가 존재합니다";

    private final String validateTarget;

    public TripleBallsValidator(String input) {
        this.validateTarget = input;
        hasThreeDigits();
        hasDupulicatedNumber();
    }

    private void hasThreeDigits() {
        if (validateTarget.length() != Util.VALID_INPUT_SIZE) {
            throw new IllegalArgumentException(NOT_THREE_DIGITS_ERROR);
        }
    }

    private void hasDupulicatedNumber() {
        List<Character> characters = Util.StringToCharList(validateTarget);
        if (characters.size() != getRemovedListCount(characters)) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_ERROR);
        }
    }

    private long getRemovedListCount(List<Character> characters) {
        return characters.stream().distinct().count();
    }
}
