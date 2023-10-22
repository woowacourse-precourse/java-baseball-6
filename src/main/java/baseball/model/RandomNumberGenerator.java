package baseball.model;

import baseball.utils.Constant;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {
    public static List<Integer> makeRandomNumber() {
        List<Integer> answerNumbers = new ArrayList<>();
        while (answerNumbers.size() < Constant.NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(Constant.MIN_NUMBER, Constant.MAX_NUMBER);
            if (!answerNumbers.contains(randomNumber)) {
                answerNumbers.add(randomNumber);
            }
        }
        return answerNumbers;
    }
}