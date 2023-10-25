package baseball.model;

import baseball.constants.Constants;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomGenerator {

    List<Integer> randomNumber = new ArrayList<>();

    public List<Integer> createRandomNumber() {
        while (randomNumber.size() < Constants.NUMBER_SIZE) {
            int singleDigitNumber = Randoms.pickNumberInRange(Constants.MIN_RANGE_NUM,
                    Constants.MAX_RANGE_NUM);
            if (!randomNumber.contains(singleDigitNumber)) {
                randomNumber.add(singleDigitNumber);
            }
        }
        return randomNumber;
    }

}
