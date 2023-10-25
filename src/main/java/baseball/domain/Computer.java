package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static final int MIN_RANDOM_NUMBER = 1;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int RANDOM_NUMBER_SIZE = 3;

    public List<Integer> generateRandomNumbers() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < RANDOM_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }

}
