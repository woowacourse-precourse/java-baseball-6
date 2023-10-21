package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {
    private List<Integer> baseballNumber;

    public Computer() {
        this.baseballNumber = new ArrayList<>(Constant.fixed_Number_Size);
    }

    public void createBaseballNumber() {
        List<Integer> randomNumber;
        do {
            randomNumber = new ArrayList<>();
            for (int i = 0; i < Constant.fixed_Number_Size; i++) {
                randomNumber.add(Randoms.pickNumberInRange(Constant.Minimum_Range, Constant.Maximum_Range));
            }
        } while (!isUnique(randomNumber) || !isRightLength(randomNumber));
        baseballNumber = new ArrayList<>(randomNumber);
    }

    private boolean isUnique(List<Integer> randomNumber) {
        Set<Integer> uniqueDigits = new HashSet<>(randomNumber);
        return uniqueDigits.size() == Constant.fixed_Number_Size;
    }

    private boolean isRightLength(List<Integer> randomNumber) {
        return randomNumber.size() == Constant.fixed_Number_Size;
    }

    public List<Integer> getBaseballNumber() {
        return baseballNumber;
    }
}