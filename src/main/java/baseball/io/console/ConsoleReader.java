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

    private String readLine() {
        return Console.readLine();
    }

}
