package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    public static final int MAX_DIGIT = 3;
    private List<Integer> computer;

    public Computer() {
        this.computer = new ArrayList<>();
        while (computer.size() < MAX_DIGIT) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public List<Integer> getComputerNumbers() {
        return List.copyOf(computer);
    }
}
