package baseball.model;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class ComputerNum {
    List<Integer> computer = new ArrayList<>();

    public ComputerNum() {
        setNumber();
    }

    public List<Integer> getComputer() {
        return this.computer;
    }

    public void setNumber() {
        while (this.computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!this.computer.contains(randomNumber)) {
                this.computer.add(randomNumber);
            }
        }
    }
}
