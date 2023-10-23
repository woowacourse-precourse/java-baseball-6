package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final int COMPUTER_NUMBER_LENGTH = 3;
    private final int MIN_RANGE = 1;
    private final int MAX_RANGE = 9;

    private final List<Integer> computerNumber = new ArrayList<>();

    public Computer() {
        generateRandomNumbers();
    }

    private void generateRandomNumbers() {
        while (computerNumber.size() < COMPUTER_NUMBER_LENGTH) {
            addComputerNumber();
        }
    }

    private void addComputerNumber() {
        int randomNumber = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
        if (!computerNumber.contains(randomNumber)) {
            computerNumber.add(randomNumber);
        }
    }

    public List<Integer> getComputerNumber() {
        return computerNumber;
    }
}