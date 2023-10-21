package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class TargetNumber {

    private final List<Integer> targetNumber;
    private static final int VALID_VALUES_LENGTH = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public TargetNumber() {
        this.targetNumber = generateComputerNumbers();
    }

    private List<Integer> generateComputerNumbers() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < VALID_VALUES_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    public List<Integer> getComputerNumbers() {
        return List.copyOf(targetNumber);
    }
}
