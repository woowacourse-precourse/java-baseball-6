package baseball;

import java.util.ArrayList;
import java.util.List;

public class Parsing {
    private static Validator validator = new Validator();

    public static List<Character> parseIntoList(String userInput) {

        List<Character> numbers = new ArrayList<>();

        validator.validateNumberInput(userInput);

        for (int i = 0; i < userInput.length(); i++) {
            Character number = userInput.charAt(i);

            validator.validateDuplicatedNumber(numbers, number);

            numbers.add(number);
        }

        return numbers;
    }
}
