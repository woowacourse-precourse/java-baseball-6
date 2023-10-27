package baseball.vo;

import java.util.Arrays;
import java.util.regex.Pattern;

public class InputNumbers {
    private static final String INPUT_NUMBER_REGEX = "^[1-9]{3}$";
    private int[] inputNumbers;

    public InputNumbers(String input) {
        validateInputNumbers(input);
        addNumbers(input);
    }

    private void validateInputNumbers(String inputStr) {
        if (!Pattern.compile(INPUT_NUMBER_REGEX).matcher(inputStr).matches()) {
            throw new IllegalArgumentException();
        }
    }

    private void addNumbers(String inputStr) {
        this.inputNumbers = Arrays.stream(inputStr.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public int[] getInputNumbers() {
        return inputNumbers;
    }
}
