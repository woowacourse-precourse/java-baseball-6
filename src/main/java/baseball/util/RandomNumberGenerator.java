package baseball.util;

import baseball.domain.Constants;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {

    public static List<Integer> generateRandomNumberList() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < Constants.NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(Constants.NUMBER_MIN, Constants.NUMBER_MAX);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

}
