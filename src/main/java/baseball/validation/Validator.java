package baseball.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.constant.NumberConstant.VALID_NUMBER_SIZE;

public class Validator {

    public void validateThreeNumber(String str) {
        if (!str.matches("[1-9]{3}")) {
            throw new IllegalArgumentException("3자리의 숫자로 이루어진 문자가 아닙니다.");
        }
    }

    public void validateDuplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);

        if (nonDuplicateNumbers.size() != VALID_NUMBER_SIZE) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
    }

    public void validate1Or2(String str) {
        if (!str.matches("[12]")) {
            throw new IllegalArgumentException("1 또는 2의 숫자만 입력해야 합니다.");
        }
    }

}
