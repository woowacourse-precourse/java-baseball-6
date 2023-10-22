package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class Computer {

    private final int[] secretNumbers = new int[3];

    public Computer() {
    }

    public int[] pickNumbers() {
        Set<Integer> numberSet = new HashSet<>();
        while (numberSet.size() < 3) {
            int newNumber = Randoms.pickNumberInRange(1, 9);
            if (numberSet.contains(newNumber))
                continue;
            secretNumbers[numberSet.size()] = newNumber;
            numberSet.add(newNumber);
        }
        return secretNumbers;
    }


}
