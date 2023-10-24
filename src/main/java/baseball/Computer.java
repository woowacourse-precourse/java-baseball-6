package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    public static List<Integer> pickNumber() {
        List<Integer> numList = new ArrayList<>();
        while (numList.size() < 3) {
            int computerNumber = Randoms.pickNumberInRange(1, 9);
            if (!numList.contains(computerNumber)) {
                numList.add(computerNumber);
            }
        }
        return numList;
    }
}
