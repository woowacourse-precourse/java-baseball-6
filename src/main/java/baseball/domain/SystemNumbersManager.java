package baseball.domain;

import baseball.resource.GameValue;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class SystemNumbersManager {

    public static String createSystemNumbers() {
        List<String> systemNumbers = new ArrayList<>();
        while (systemNumbers.size() < 3) {
            duplicateNumberCheck(systemNumbers, createSingleNumber());
        }
        return String.join("", systemNumbers);
    }

    private static String createSingleNumber() {
        return Integer.toString(Randoms.pickNumberInRange(GameValue.MIN_NUMBER, GameValue.MAX_NUMBER));
    }

    private static void duplicateNumberCheck(List<String> numberList, String number) {
        if (!numberList.contains(number)) {
            numberList.add(number);
        }
    }
}
