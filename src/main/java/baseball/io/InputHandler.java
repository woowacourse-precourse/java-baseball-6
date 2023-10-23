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
        // 3가지 예외처리를 담당 1.예측값 충복체크 2.(1-9)범위 체크 3.3개의 숫자인지 체크
        if (!validExpectedNums(expectedNums)) {
            throw new IllegalArgumentException();
        }

        return expectedNums;
    }
}
