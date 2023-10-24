package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static final int INPUT_LENGTH = 3;
    private static final int MAXIMUM_NUMBER = 9;
    private static final int MINIMUM_NUMBER = 1;

    private List<Integer> computerList;


    public Computer() {
    }

    public void generateComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < INPUT_LENGTH) {
            int randomNumber = generateRandomNumber();
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        this.computerList = computer;
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER);
    }

    public List<Integer> getComputerList() {
        return this.computerList;
    }
}
