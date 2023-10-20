package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String COMMA = ",";
    private final InputValidator validator = new InputValidator();

    public List<Integer> readNumbers() {
        String number = Console.readLine();
        validator.validateNumber(number);
        return Arrays.stream(number.split(COMMA))
                .map(Integer::parseInt)
                .toList();
    }
}