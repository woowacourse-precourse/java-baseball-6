package baseball.model;

import baseball.exception.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Util {

    private final InputValidator inputValidator;

    public Util() {
        inputValidator = new InputValidator();
    }

    public List<Integer> parseToNumberList(String convertValue) {
        if(!inputValidator.isNumeric(convertValue)) {
            throw new IllegalArgumentException();
        }

        return Arrays.stream(convertValue.split(""))
                .mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());
    }
}
