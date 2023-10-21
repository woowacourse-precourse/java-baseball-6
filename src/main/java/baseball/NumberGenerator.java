package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.ArrayList;

/**
 * 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 생성하는 클래스이다.
 */
public class NumberGenerator {
    public static final Integer MIN_RANDOM_NUMBER = 1;
    public static final Integer MAX_RANDOM_NUMBER = 9;
    
    public List<Integer> getThreeRandomNumbers() {
        final int RETURN_NUMBER_SIZE = 3;
        List<Integer> returnNumbers = new ArrayList<>();

        while(returnNumbers.size() < RETURN_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            if (!returnNumbers.contains(randomNumber)) {
                returnNumbers.add(randomNumber);
            }
        }

        return returnNumbers;
    }
}
