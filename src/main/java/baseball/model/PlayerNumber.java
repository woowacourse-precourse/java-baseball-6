package baseball.model;

import baseball.util.NumberValidator;
import java.util.ArrayList;
import java.util.List;

public class PlayerNumber {
    private List<Integer> numbers;
    NumberValidator numberValidator = new NumberValidator();

    public void setInputNumber(String inputNumber) {
        numberValidator.validateDigit(inputNumber);
        numberValidator.validateRange(inputNumber);
        numberValidator.validateDuplicateNumber(inputNumber);
        numberValidator.validateNonNumeric(inputNumber);

        this.numbers = convertStringToInt(inputNumber);
    }

    public List<Integer> convertStringToInt(String inputNumber) {
        ArrayList<Integer> transformNumbers = new ArrayList<>();
        for (char number : inputNumber.toCharArray()) {
            transformNumbers.add(Character.getNumericValue(number));
        }
        return transformNumbers;
    }
}
