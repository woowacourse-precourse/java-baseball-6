package baseball;

import camp.nextstep.edu.missionutils.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Computer {

    private List<Integer> computerNums;

    public Computer(int size) {
        createRandomNums(size);
    }

    private void createRandomNums(int size) {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < size) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        this.computerNums = computer;
    }

    public List<Integer> getNums() {
        return Collections.unmodifiableList(computerNums);
    }
}
