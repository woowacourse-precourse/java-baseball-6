package baseball.controller;

import java.util.ArrayList;
import java.util.List;

import static baseball.common.Common.*;
import static baseball.domain.GameConst.INPUT_NUMS;
import static camp.nextstep.edu.missionutils.Console.*;

public class Input {

    public static String inputNums() {
        System.out.print(INPUT_NUMS);
        String input = readLine();
        validateInput(input);
        return input;
    }

    public static String inputRetryNum() {
        String input = readLine();
        validateRetryInput(input);
        return input;
    }

    public static List<Integer> parseInputToList(String inputNums) {
        List<Integer> numbers = new ArrayList<>();
        for (char digit : inputNums.toCharArray()) {
            numbers.add(Character.getNumericValue(digit));
        }
        return numbers;
    }

}
