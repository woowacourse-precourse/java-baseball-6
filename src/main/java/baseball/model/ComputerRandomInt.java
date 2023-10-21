package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;

public class ComputerRandomInt {
    public void randomNum() {
        HashSet computer = new HashSet();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
}
