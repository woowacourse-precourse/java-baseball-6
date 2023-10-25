package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final List<Integer> computerNumber = new ArrayList<>();

    public Computer() {
        generateRandomNumbers();
    }

    private void generateRandomNumbers() {
        while (computerNumber.size() < Constant.NUMBER_LENGTH) {
            addComputerNumber();
        }
    }

    private void addComputerNumber() {
        int randomNumber = Randoms.pickNumberInRange(Constant.MIN_RANGE, Constant.MAX_RANGE);
        if (!computerNumber.contains(randomNumber)) {
            computerNumber.add(randomNumber);
        }
    }

    public List<Integer> getComputerNumber() {
        return computerNumber;
    }
}