package baseball.domain.validators;

import baseball.utils.NumberUtils;
import baseball.utils.StringUtils;

public class InputValidator {

    public void validateUniqueNumbers(int numberLimit, String input) {
        if (input.length() != numberLimit)
            throw new IllegalArgumentException(numberLimit + "개의 숫자만 허용합니다.");
        if (!NumberUtils.isNumeric(input))
            throw new IllegalArgumentException("숫자만 허용합니다.");
        if (StringUtils.hasDuplicateCharacters(input))
            throw new IllegalArgumentException("중복된 숫자는 허용하지 않습니다.");
    }

    public void validateSingleNumber(String input) {
        if (input.length() != 1)
            throw new IllegalArgumentException("1개의 숫자만 허용합니다.");
        if (!NumberUtils.isNumeric(input))
            throw new IllegalArgumentException("숫자만 허용합니다.");
    }
}
