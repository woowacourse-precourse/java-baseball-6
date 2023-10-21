package baseball.domain.number;

import baseball.domain.validation.Validation;
import java.util.List;

public class Number {

    private final List<Integer> number;

    public Number(String inputNumber) {
        List<Integer> number = stringToIntegerList(inputNumber);
        Validation.validNumber(inputNumber, number);
        this.number = number;
    }

    public List<Integer> toIntList() {
        return number;
    }

    private List<Integer> stringToIntegerList(String inputNumber) {
        return inputNumber.chars()
                .map(Character::getNumericValue)
                .boxed()
                .toList();
    }

}
