package baseball.validation;

import java.util.Arrays;
import java.util.List;

public class BaseballGameValidation {

    private final int SIZE_COUNT = 3;
    private final String START_GAME = "1";
    private final String END_GAME = "2";

    public void validateString(String checkString){
        if (!Arrays.asList(START_GAME, END_GAME).contains(checkString))
            throw new IllegalArgumentException();
    }

    public void checkBaseballNumberSize(List<Integer> baseballNumbers) {
        if (baseballNumbers.size() != SIZE_COUNT)
            throw new IllegalArgumentException();
    }

    public void validateBaseballNumber(String baseBallNumberStr) {
        if (baseBallNumberStr.chars().distinct().count() != SIZE_COUNT)
            throw new IllegalArgumentException();
    }

    public boolean checkDigit(char baseballChar){
        return (Character.isDigit(baseballChar) && Character.getNumericValue(baseballChar) != 0);
    }
}
