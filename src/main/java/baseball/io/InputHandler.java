package baseball.io;


import static baseball.validation.InputValidation.validExpectedNums;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputHandler {

    public Integer scanInteger() {
        int input;
        try {
            input = Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        return input;
    }

    public List<Integer> inputToExpectedNumber(int input) {
        List<Integer> expectedNums = new ArrayList<>();
        while (input > 0) {
            expectedNums.add(0, input % 10);
            input /= 10;
        }
        if (!validExpectedNums(expectedNums)) {
            throw new IllegalArgumentException();
        }

        return expectedNums;
    }
}
