package baseball.validator;

import baseball.model.Baseball;
import baseball.model.BaseballNumber;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballValidator {

    public static final String INVALID_LENGTH_ERROR_MESSAGE = "길이가 3이어야 합니다.";
    public static final String DUPLICATED_NUMBER_ERROR_MESSAGE = "각 숫자가 중복되지 않아야 합니다.";

    //인스턴스화 방지
    private BaseballValidator() {
        throw new AssertionError();
    }

    public static void validate(List<BaseballNumber> baseballNumbers) {
        validateLength(baseballNumbers);
        validateUnique(baseballNumbers);
    }

    private static void validateLength(List<BaseballNumber> baseballNumbers) {
        if (baseballNumbers.size() != Baseball.LENGTH) {
            throw new IllegalArgumentException(INVALID_LENGTH_ERROR_MESSAGE);
        }
    }

    private static void validateUnique(List<BaseballNumber> baseballNumbers) {
        Set<BaseballNumber> uniqueNumbers = new HashSet<>(baseballNumbers);
        if (uniqueNumbers.size() != Baseball.LENGTH) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_ERROR_MESSAGE);
        }
    }
}
