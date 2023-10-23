package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {


    public List<Integer> generateRandomNumber() {
        List<Integer> randomNumber = new ArrayList<>();

        while (randomNumber.size() < Number.NUMBER_SIZE) {
            int digit = Randoms.pickNumberInRange(1, 9);
            addUniqueNumber(randomNumber, digit);
        }
        return randomNumber;
    }

    private void addUniqueNumber(List<Integer> randomNumber, int digit) {
        if (!randomNumber.contains(digit)) {
            randomNumber.add(digit);
        }
    }
}
