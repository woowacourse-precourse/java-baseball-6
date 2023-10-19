package baseball.model;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    private final List<Integer> computer;

    public Computer(List<Integer> computer) {
        this.computer = computer;
    }

    public void generateRandom() {
        while(computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
}
