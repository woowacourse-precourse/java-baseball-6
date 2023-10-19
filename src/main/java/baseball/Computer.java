package baseball;

import static baseball.Constants.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private Numbers numbers;

    public void generateRandomNumbers() {
        List<Integer> randomGeneratedNumberList = new ArrayList<>();
        while (randomGeneratedNumberList.size() < NUM_DIGITS.getValue()) {
            int randomNumber = Randoms.pickNumberInRange(
                    RANDOM_NUMBER_LOWER_BOUND.getValue(),
                    RANDOM_NUMBER_UPPER_BOUND.getValue()
            );
            if (!randomGeneratedNumberList.contains(randomNumber)) {
                randomGeneratedNumberList.add(randomNumber);
            }
        }
        this.numbers = new Numbers(randomGeneratedNumberList);
    }
}
