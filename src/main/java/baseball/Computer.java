package baseball;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class Computer {

    private List<Integer> computer = new ArrayList<>();

    void setComputer() {
        while (this.computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    List<Integer> getComputer() {
        return computer;
    }

    void clearComputer() {
        computer.clear();
    }
}
