package baseball.validator;

import baseball.model.CompareNumbers;

import java.util.List;

public class CompareValidator {
    private final CompareNumbers compareNumbers;

    public CompareValidator() {
        compareNumbers = new CompareNumbers();
    }

    public int[] getNumberCompare(List<Integer> computerNumbers, List<Integer> playerNumbers){

        return compareNumbers.getNumberCompareResult(computerNumbers, playerNumbers);
    }

    public boolean isStrike() {
        if (compareNumbers.getStrike() == 3) {
            return true;
        }
        return false;
    }
}
