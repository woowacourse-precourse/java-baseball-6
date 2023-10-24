package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final List<Integer> target;

    public Computer(int inputSize) {
        target = new ArrayList<>(inputSize);
        setTarget();
    }

    private void setTarget() {
        while (target.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!target.contains(randomNumber)) {
                target.add(randomNumber);
            }
        }
    }

    public List<Integer> getTarget() {
        return target;
    }
}
