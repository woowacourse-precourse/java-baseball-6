package baseball.validation;

import static baseball.constant.Message.INPUT_DIGIT_EXCEPTION_MSG;
import static baseball.constant.Message.INPUT_NATURAL_NUMBER_EXCEPTION_MSG;
import static baseball.constant.Message.INPUT_STRING_EXCEPTION_MSG;
import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class InputValidation {

    private void checkInputLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException(INPUT_DIGIT_EXCEPTION_MSG);
        }
    }

    private int checkNumber(String input) {
        int index = 0;
        try {
            index = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_STRING_EXCEPTION_MSG);
        }
        return index;
    }

    private LinkedHashSet<Integer> checkSetLength(LinkedHashSet<Integer> set) {
        if (set.size() != 3) {
            throw new IllegalArgumentException(INPUT_NATURAL_NUMBER_EXCEPTION_MSG);
        }
        return set;
    }

    private LinkedHashSet<Integer> checkInputNumber(String input) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < 3; i++) {
            int index = checkNumber(String.valueOf(input.charAt(i)));
            if (index != 0) {
                set.add(index);
            }
        }
        return checkSetLength(set);
    }


    public ArrayList<Integer> startInput() {
        String input = readLine();
        checkInputLength(input);
        return new ArrayList<>(checkInputNumber(input));
    }
}
