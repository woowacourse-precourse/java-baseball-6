package baseball.model;

import java.util.List;

public class BaseballNumbers {
    private static final int BASEBALL_NUMBERS_LENGTH = 3;
    private final List<BaseballNumber> baseballNumbers;

    public BaseballNumbers(List<BaseballNumber> baseballNumbers) {
        validateBaseballNumbers(baseballNumbers);
        this.baseballNumbers = baseballNumbers;
    }

    private void validateBaseballNumbers(List<BaseballNumber> baseballNumbers) {
        if (baseballNumbers.size() != BASEBALL_NUMBERS_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 숫자야구 값의 길이가 " + BASEBALL_NUMBERS_LENGTH + "(이)가 아닙니다.");
        }
        List<BaseballNumber> distinctBaseballNumbers = baseballNumbers.stream()
                .distinct()
                .toList();
        if (baseballNumbers.size() != distinctBaseballNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 숫자야구 값에 중복 값이 있습니다.");
        }
    }

    public BaseballNumber getBaseballNumber(int index) {
        return baseballNumbers.get(index);
    }

    public boolean containsBaseballNumber(BaseballNumber baseballNumber) {
        return baseballNumbers.contains(baseballNumber);
    }
}
