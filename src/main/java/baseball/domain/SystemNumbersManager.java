package baseball.domain;

import baseball.resource.GameValue;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class SystemNumbersManager {

    public static List<Integer> createSystemNumbers() {
        List<Integer> systemNumbers = new ArrayList<>();
        while (systemNumbers.size() < 3) {
            duplicateNumberCheck(systemNumbers, createSingleNumber());
        }
        return systemNumbers;
    }

    private static int createSingleNumber() {
        return Randoms.pickNumberInRange(GameValue.MIN_NUMBER, GameValue.MAX_NUMBER);
    }

    private static void duplicateNumberCheck(List<Integer> numberList, int number) {
        if (!numberList.contains(number)) {
            numberList.add(number);
        }
    }
}
