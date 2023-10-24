package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    
    private static final int START_NUMBER_OF_RANDOM = 1;
    private static final int END_NUMBER_OF_RANDOM = 9;
    private static final int COMPUTER_NUMBER_LENGTH = 3;

    public static List<Integer> createRandomComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>();

        while (computerNumber.size() < COMPUTER_NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(START_NUMBER_OF_RANDOM, END_NUMBER_OF_RANDOM);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }
}
