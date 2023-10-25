package number;

import java.util.*;
import camp.nextstep.edu.missionutils.*;

public class ComputerNumberGenerator {
    private static final int COMPUTER_NUMBER_MAX_SIZE = 3;
    private static final int COMPUTER_NUMBER_MIN_NUMBER = 1;
    private static final int COMPUTER_NUMBER_MAX_NUMBER = 9;

    public ComputerNumber createComputerNumber() {
        List<Integer> number = new ArrayList<>();
        extractedComputerNumber(number);
        ComputerNumber computerNumber = new ComputerNumber(number);

        return computerNumber;
    }

    private void extractedComputerNumber(List<Integer> computer) {
        while (computer.size() < COMPUTER_NUMBER_MAX_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(COMPUTER_NUMBER_MIN_NUMBER, COMPUTER_NUMBER_MAX_NUMBER);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
}
