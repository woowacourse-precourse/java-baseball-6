package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Computer {
    private final List<Integer> computer;

    public Computer(List<Integer> computer) {
        this.computer = computer;
    }

    public void createComputerNumber(int length) {
        while (computer.size() < length) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public int get(int idx) {
        return computer.get(idx);
    }

    public boolean contains(int value) {
        if (computer.contains(value)) {
            return true;
        } else {
            return false;
        }
    }
}
