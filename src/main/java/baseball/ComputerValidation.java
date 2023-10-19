package baseball;

import java.util.List;

public class ComputerValidation implements Validate {

    private final List<Integer> answerList;

    public ComputerValidation(List<Integer> answerList) {
        this.answerList = answerList;
    }

    @Override
    public boolean validatedInput() {
        if (notSameElementOfList() && elementsValue1To9OfList()) {
            return true;
        }
        return false;
    }

    private boolean notSameElementOfList() {
        return this.answerList.stream().distinct().count() == 3;
    }

    private boolean elementsValue1To9OfList() {
        for (Integer number : answerList) {
            if ((number >= 1) && (number <= 9)) {
                return true;
            }
        }
        return false;
    }
}