package baseball.domain;

import baseball.validator.NumberValidator;
import java.util.ArrayList;
import java.util.List;

public class Numbers {

    public static final Integer MAX_NUMBER = 9;
    public static final Integer MIN_NUMBER = 1;
    public static final Integer NUMBER_COUNT = 3;
    private List<Integer> numberList;

    private Numbers() {
    }

    public static Numbers create(List<Integer> numberList) {
        validateNumberList(numberList);

        Numbers numbers = new Numbers();
        numbers.setNumberList(numberList);

        return numbers;
    }

    private static void validateNumberList(List<Integer> numberList) {
        NumberValidator.validateNumberSize(numberList);
        NumberValidator.validateNumberRange(numberList);
        NumberValidator.validateDuplicateNumber(numberList);
    }


    public List<Integer> getNumberList() {
        return new ArrayList<>(numberList);
    }

    private void setNumberList(List<Integer> numberList) {
        this.numberList = numberList;
    }
}
