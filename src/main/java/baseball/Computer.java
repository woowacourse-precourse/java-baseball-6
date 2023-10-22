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
        while (computerNumber.size() < 3) {
            addComputerNumber();
        }
    }

    private void addComputerNumber() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!computerNumber.contains(randomNumber)) {
            computerNumber.add(randomNumber);
        }
    }

    public List<Integer> getComputerNumber() {
        return computerNumber;
    }
}