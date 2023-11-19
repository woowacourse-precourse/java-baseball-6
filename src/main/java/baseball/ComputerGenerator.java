package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerGenerator {

    public List<Integer> createNumber() {
        List<Integer> computer = new ArrayList<>();
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        while (computer.size() < 3) {
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
