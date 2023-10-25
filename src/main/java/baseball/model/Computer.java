package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int COMPUTER_NUMBER_LENGTH = 3;
    private static final int COMPUTER_NUMBER_MINIMUM = 1;
    private static final int COMPUTER_NUMBER_MAXIMUM = 9;
    private List<Integer> computerNumber = new ArrayList<>();

    public void createComputerNumber() {
        computerNumber.clear();
        while (computerNumber.size() < COMPUTER_NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(COMPUTER_NUMBER_MINIMUM, COMPUTER_NUMBER_MAXIMUM);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }

    public List<Integer> getComputerNumber() {
        return computerNumber;
    }
}
