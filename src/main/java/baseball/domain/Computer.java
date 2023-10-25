package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class Computer {
    private static final int MIN_VAL = 1;
    private static final int MAX_VAL = 9;
    private static final int NUM_SIZE = 3;
    private final List<Integer> computerNumbers;
    private Computer() {
        this.computerNumbers = createRandomNumbers();
    }

    public static Computer createComputer() {
        return new Computer();
    }

    private List<Integer> createRandomNumbers() {
        ArrayList<Integer> computer = new ArrayList<>();

        while (computer.size() < NUM_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_VAL, MAX_VAL);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }
}
