package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComputerNumber {

    public static final int RANDOM_NUMBER_SIZE = 3;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;

    private final List<Integer> computer = new ArrayList<>();
    private int randomNumber;

    public ComputerNumber() {
        createComputerNumbers();
    }

    public List<Integer> getComputer() {
        return Collections.unmodifiableList(computer);
    }

    private void createComputerNumbers() {
        while (computer.size() < RANDOM_NUMBER_SIZE) {
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
        randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
