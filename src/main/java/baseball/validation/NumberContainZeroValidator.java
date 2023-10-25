package baseball.validation;

import baseball.util.ArrayConverterUtil;

/**
 * @author 민경수
 * @description number contain zero validator
 * @since 2023.10.23
 **********************************************************************************************************************/
public class NumberContainZeroValidator implements NumberValidator {

    @Override
    public void validate(int[] number) {
        if (ArrayConverterUtil.converIntArrayToList(number).contains(0)) {
            throw new IllegalArgumentException("숫자 0은 포함될 수 없습니다.");
        }
    }

}