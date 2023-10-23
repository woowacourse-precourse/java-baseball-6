package baseball.model;

import baseball.utils.Validator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 유저에게 입력받은 숫자로만 이루어진 String을 포장하는 클래스
 */

public class StringNumbers {
    private final String stringNumbers;

    /**
     * 유저에게 입력받은 String이 숫자로만 이루어져 있는지 검증 후 포장하여 객체로 반환
     *
     * @param stringNumbers 유저에게 입력받은 String 값
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
     * 유저에게 입력받은 숫자로만 이루어진 String을 Integer 리스트 형태로 분리하여 반환
     *
     * @return 숫자로만 이루어진 String을 분리한 Integer 리스트
     */

    public List<Integer> translateToIntegerList() {
        return stringNumbers.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }
}
