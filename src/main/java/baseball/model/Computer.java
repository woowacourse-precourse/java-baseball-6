package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> computerNumber;

    public Computer() {
        this.computerNumber = drawComputerNumber();
    }

    public List<Integer> getComputerNumber() {
        return computerNumber;
    }

    private List<Integer> drawComputerNumber(){
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
