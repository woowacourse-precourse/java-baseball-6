package process;

import camp.nextstep.edu.missionutils.Randoms;
import validation.ValidationNumber;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber {
    private final int RANDOM_NUMBER_SIZE = 3;
    private RandomNumber() {
    }

    public static RandomNumber of() {
        return new RandomNumber();
    }

    public List<Integer> getRandomNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < RANDOM_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        ValidationNumber.validateNumbers(computerNumber);
        return computerNumber;
    }
}
