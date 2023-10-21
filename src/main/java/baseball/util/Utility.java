package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Utility {

    private static List<Integer> assignComputerRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }
}

