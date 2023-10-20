package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    public static List<Integer> comNumberList() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNum)) {
                computer.add(randomNum);
            }
        }
        return computer;
    }
}
