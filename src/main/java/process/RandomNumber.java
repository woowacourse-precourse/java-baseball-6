package process;

import camp.nextstep.edu.missionutils.Randoms;
import validation.ValidationNumber;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber {
    private RandomNumber() {
    }

    public static RandomNumber of() {
        return new RandomNumber();
    }

    public List<Integer> getRandomNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        ValidationNumber.validateNumbers(computerNumber);
        return computerNumber;
    }
}
