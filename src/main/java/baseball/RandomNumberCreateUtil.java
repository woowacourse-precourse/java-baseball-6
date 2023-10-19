package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberCreateUtil {
    private RandomNumberCreateUtil() {
        throw new IllegalStateException("RandomNumberCreateUtil class Error");
    }

    public static List<Integer> createBaseballNumbers(){
        List<Integer> baseballNumbers = new ArrayList<>();
        while (baseballNumbers.size() < BaseballRole.MAX_BASEBALL_NUMBER_SIZE.getValue()) {
            int randomNumber = Randoms.pickNumberInRange(BaseballRole.MIN_BASEBALL_NUMBER.getValue()
                    , BaseballRole.MAX_BASEBALL_NUMBER.getValue());
            if (!baseballNumbers.contains(randomNumber)) {
                baseballNumbers.add(randomNumber);
            }
        }
        return baseballNumbers;
    }

}