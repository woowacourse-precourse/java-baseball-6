package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static final int START_NUMBER_OF_RANDOM = 1;
    private static final int END_NUMBER_OF_RANDOM = 9;

    private List<Integer> computerNumber;
    
    public List<Integer> createNumber() {
        computerNumber = new ArrayList<>();

        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(START_NUMBER_OF_RANDOM, END_NUMBER_OF_RANDOM);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }
}
