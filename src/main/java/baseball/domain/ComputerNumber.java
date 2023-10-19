package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {

    private final List<Integer> computer;
    private int randomNumber;

    public ComputerNumber() {
        this.computer = new ArrayList<>();
    }

    public void createComputerNumbers() {
        while (computer.size() < 3) {
            addComputerNumber();
        }
    }

    private void addComputerNumber() {
        createRandomNumber();

        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber);
        }
    }

    private void createRandomNumber() {
        randomNumber = Randoms.pickNumberInRange(1, 9);
    }
}
