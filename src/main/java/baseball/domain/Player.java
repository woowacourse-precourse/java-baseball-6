package baseball.domain;


import baseball.constant.Regex;
import baseball.util.InputValidator;
import java.util.ArrayList;
import java.util.List;

public class Player {

    public List<Integer> getInputNumber(String input) {
        if (InputValidator.isValid(input)) {
            return convertStringToList(input);
        }
        throw new IllegalArgumentException();
    }

    public int receiveRetryOption(String input) {
        if (Regex.ONE_OR_TWO.matches(input)) {
            return Integer.parseInt(input);
        }
        throw new IllegalArgumentException();
    }

    private List<Integer> convertStringToList(String input) {
        List<Integer> inputNumbers = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            inputNumbers.add(Character.getNumericValue(ch));
        }
        return inputNumbers;
    }
}