package baseball.model;

import static baseball.utils.Constant.MAX_NUMBER;
import static baseball.utils.Constant.MIN_NUMBER;
import static baseball.utils.Constant.NUMBER_LENGTH;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {
    public static List<Integer> makeRandomNumber() {
        List<Integer> answerNumbers = new ArrayList<>();
        while (answerNumbers.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!answerNumbers.contains(randomNumber)) {
                answerNumbers.add(randomNumber);
            }
        }
        return answerNumbers;
    }
}