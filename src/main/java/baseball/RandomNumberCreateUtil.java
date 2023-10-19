package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberCreateUtil {

    public static final int MAX_BASEBALL_NUMBER_SIZE = 3;
    public static final int MIN_RANDOM_NUMBER = 1;
    public static final int MAX_RANDOM_NUMBER = 9;

    public static List<Integer> createBaseballNumbers(){
        List<Integer> baseballNumbers = new ArrayList<>();
        while (baseballNumbers.size() < MAX_BASEBALL_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            if (!baseballNumbers.contains(randomNumber)) {
                baseballNumbers.add(randomNumber);
            }
        }
        return baseballNumbers;
    }

}