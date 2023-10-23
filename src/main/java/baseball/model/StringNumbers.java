package baseball.model;

import baseball.utils.Validator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 숫자로만 이루어진 String을 포장하는 클래스입니다.
 */

public class StringNumbers {
    private final String stringNumbers;

    /**
     * String이 숫자로만 이루어져 있는지 검증 후 객체로 반환합니다.
     *
     * @param stringNumbers 숫자로만 이루어져 있는지 검증할 String 값
     */

    public StringNumbers(String stringNumbers) {
        validateStringNumbers(stringNumbers);
        this.stringNumbers = stringNumbers;
    }

    private void validateStringNumbers(String stringNumbers) {
        Validator.validateStringEmptyOrNull(stringNumbers);
        Validator.validateStringDigit(stringNumbers);
    }

    /**
     * 숫자로만 이루어진 String을 Integer 리스트 형태로 변환 후 반환합니다.
     *
     * @return 숫자로만 이루어진 String이 변환된 Integer 리스트
     */

    public List<Integer> translateToIntegerList() {
        return stringNumbers.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }
}
