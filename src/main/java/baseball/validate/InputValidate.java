package baseball.validate;

import java.util.ArrayList;
import java.util.List;

public class InputValidate {
    public List<Integer> checkNumbers(String givenNumbers) {
        List<Integer> validatedNumbers = new ArrayList<>();
        String[] numbers = givenNumbers.split("");
        for(String number : numbers) {
            validatedNumbers.add(checkNumber(number));
        }
        return validatedNumbers;
    }

    public Integer checkNumber(String givenNumber) {
        try {
            return Integer.parseInt(givenNumber);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] : Input " + givenNumber);
        }
    }
}