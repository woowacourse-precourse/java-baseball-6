package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class TargetNumber {

    private final List<Integer> targetNumber;

    public TargetNumber() {
        this.targetNumber = generateComputerNumbers();
    }

    private List<Integer> generateComputerNumbers() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

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
