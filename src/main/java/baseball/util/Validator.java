package baseball.util;

import java.util.List;

public class Validator {
    private NumberCompare compare;

    public Validator() {
        compare = new NumberCompare();
    }

    public int[] getValidator(List<Integer> computer, List<Integer> user) {
        return this.compare.CompareNumber(computer, user);
    }

    public boolean isThreeStrike() {
        if (this.compare.getStrike() == 3) {
            return true;
        } else {
            return false;
        }
    }
}
