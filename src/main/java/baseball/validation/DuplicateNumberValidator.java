package baseball.validation;

import java.util.Arrays;

/**
 * @author 민경수
 * @description duplicate number validator
 * @since 2023.10.23
 **********************************************************************************************************************/
public class DuplicateNumberValidator implements NumberValidator {

    @Override
    public void validate(int[] number) {
        if (Arrays.stream(number).distinct().count() != number.length) {
            throw new IllegalArgumentException("반복되는 숫자가 있습니다.");
        }
    }

}