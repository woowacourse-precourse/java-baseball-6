package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Input {
    private static final int INPUT_SIZE = 3;

    String input;

    public Input checkValidate() {
        this.input = Console.readLine();
        validateNumberLength(input);
        validateNumber(input);
        validateDuplicate(input);
        validateZero(input);
        return this;
    }

    public List<Integer> toList() {
        return Arrays.stream(input.split(""))
                .map(string -> Integer.parseInt(string))
                .toList();
    }

    private void validateNumberLength(String input) {
        if(input.length() != INPUT_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch(NumberFormatException numberFormatException) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(String input) {
        Object[] splitedInput = Arrays.stream(input.split(""))
                .distinct()
                .toArray();

        if(splitedInput.length != INPUT_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateZero(String input) {
        boolean isExist = Arrays.asList(input.split("")).contains("0");

        if(isExist) {
            throw new IllegalArgumentException();
        }
    }
}
