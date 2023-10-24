package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    public static List<Integer> pickNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int computerNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(computerNumber)) {
                computer.add(computerNumber);
            }
        }
        return computer;
    }
}
