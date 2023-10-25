package baseball.domain;

import baseball.exception.NumbersInputException;
import baseball.utils.Util;
import baseball.vo.Number;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerNumbers implements Numbers{

    private final List<Number> playerNumbers;

    public PlayerNumbers(String numbersString) {


        List<Number> numbers = stringToNumbers(numbersString);
        checkDuplication(numbers);
        checkLength(numbers);

        this.playerNumbers = new ArrayList<>(numbers);

    }

    private List<Number> stringToNumbers(String numbersString) {
        try {
            Util.checkNumeric(numbersString);
        } catch (IllegalArgumentException e) {
            throw new NumbersInputException();
        }
        return numbersString.chars()
                            .mapToObj(number -> Character.getNumericValue((char)number))
                            .map(Number::new)
                            .toList();

    }

    public Number showNumberAt(int index) {
        Number number = playerNumbers.get(index);
        return new Number(number.showValue());
    }

}
