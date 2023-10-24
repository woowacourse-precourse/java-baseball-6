package baseball.io.console;

import baseball.constant.NumberConstant;
import baseball.constant.StringConstant;
import baseball.utils.NumberValidator;
import baseball.utils.StringValidator;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class ConsoleReader {

    public List<Integer> readThreeNumbers() {
        String input = readLine();

        StringValidator.validateHasLength(input, NumberConstant.THREE);
        NumberValidator.validateContainsOnlyDigits(input);

        return Arrays.stream(input.split(StringConstant.EMPTY_STRING))
                .map(Integer::parseInt)
                .toList();
    }

    public int readOneOrTwo() {
        String input = readLine();

        NumberValidator.validateContainsOnlyDigits(input);
        StringValidator.validateHasLength(input, 1);

        int number = Integer.parseInt(input);
        validateContainsOnlyOneOrTwo(number);

        return number;
    }

    private void validateContainsOnlyOneOrTwo(int number) {
        if (!List.of(NumberConstant.ONE, NumberConstant.TWO).contains(number)) {
            throw new IllegalArgumentException("Number %d is not 1 or 2.".formatted(number));
        }
    }

    private String readLine() {
        return Console.readLine();
    }

}
