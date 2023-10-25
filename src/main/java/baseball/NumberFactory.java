package baseball;
import camp.nextstep.edu.missionutils.Randoms;

import java.beans.PropertyEditorSupport;
import java.util.*;

public abstract class NumberFactory {

    public static int createNumber(int digitSize) {
        Set<Integer> numberSet = new LinkedHashSet<>();

        while (numberSet.size() < digitSize) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            numberSet.add(randomNumber);
        }

        return combineNumber(numberSet);
    }

    private static int combineNumber(Set<Integer> numberSet) {
        int result = 0;
        for (int num : numberSet) {
            result *= 10;
            result += num;
        }

        return result;
    }
}