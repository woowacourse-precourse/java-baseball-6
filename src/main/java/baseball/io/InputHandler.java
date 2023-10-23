package baseball.io;


import static baseball.validation.InputValidation.validExpectedNums;
import static baseball.validation.InputValidation.validParseNumeric;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputHandler {

    public Integer scanInteger() {
        String input = Console.readLine();
        return validParseNumeric(input);
    }

    public List<Integer> inputToExpectedNumber(int input) {
        List<Integer> expectedNums = new ArrayList<>();
        while (input > 0) {
            expectedNums.add(0, input % 10);
            input /= 10;
        }
        validExpectedNums(expectedNums);

        return expectedNums;
    }
}
