package baseball.validation;

import java.util.Arrays;
import java.util.List;

public class BaseballGameValidation {

    public void validateString(String checkString){
        if (!Arrays.asList("1", "2").contains(checkString))
            throw new IllegalArgumentException();
    }

    public void checkBaseballNumberSize(List<Integer> baseballNumbers) {
        if (baseballNumbers.size() != 3)
            throw new IllegalArgumentException();
    }

    public void validateBaseballNumber(String baseBallNumberStr) {
        if (baseBallNumberStr.chars().distinct().count() != 3)
            throw new IllegalArgumentException();
    }
}
