package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final int MAX_NUMBER = 9;
    private final int MIN_NUMBER = 1;

    public List<Integer> generateNumber() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }
}
