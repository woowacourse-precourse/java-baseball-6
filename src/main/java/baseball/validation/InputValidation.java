package baseball.validation;

import baseball.utils.Constant;
import java.util.ArrayList;
import java.util.List;

public class InputValidation {
    public static void verifyInputNum(String inputNum) {
        verifyLength(inputNum);
        verifyRangeAndType(inputNum);
        verifyDuplication(inputNum);
    }

    private static void verifyLength(String inputNum) {
        if (inputNum.length() != Constant.NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private static void verifyRangeAndType(String inputNum) {
        if (!inputNum.matches("^[1-9]*$")) {
            throw new IllegalArgumentException();
        }
    }

    private static void verifyDuplication(String inputNum) {
        List<Character> checkList = new ArrayList<>();
        for (char partNum : inputNum.toCharArray()) {
            if (checkList.contains(partNum)) {
                throw new IllegalArgumentException();
            }
            checkList.add(partNum);
        }
    }

}