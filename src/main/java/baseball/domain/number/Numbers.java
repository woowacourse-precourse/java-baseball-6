package baseball.domain.number;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

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
