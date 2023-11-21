package baseball.util.parser;

import baseball.util.validator.Validator;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    private static final String INPUT_SEPARATOR = "";

    public static List<Integer> parseToNumeric(String userInput) {
        Validator.validateEmpty(userInput);
        Validator.validateNumeric(userInput);

        return Arrays.stream(userInput.split(INPUT_SEPARATOR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int parseToInt(String userInput) {
        return Integer.parseInt(userInput);
    }

}
