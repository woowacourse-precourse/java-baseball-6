package baseball;

import java.util.List;
import java.util.regex.Pattern;

public class ValidateInputNumber {

    public boolean validateWithRegex(String inputNumber) {
        if (!Pattern.matches("^[0-9]{3}$", inputNumber)) {
            throw new IllegalArgumentException("only numbers can be entered");
        }
        return true;
    }

    public void validateResult(List<Integer> inputNumberList) {
        if (!validateCount(inputNumberList)) {
            throw new IllegalArgumentException("the number is out of range.");
        }

        if (!validateDuplicate(inputNumberList)) {
            throw new IllegalArgumentException("the numbers are duplicated");
        }
    }

    private boolean validateCount(List<Integer> inputNumberList) {
        if (inputNumberList.size() != 3) {
            return false;
        }
        return true;
    }

    private boolean validateDuplicate(List<Integer> inputNumberList) {
        for (int i = 0; i < 2; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (inputNumberList.get(i) == inputNumberList.get(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
