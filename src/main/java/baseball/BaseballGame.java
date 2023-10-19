package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;
public class BaseballGame {
    public List<Integer> makeBaseballNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }


}
