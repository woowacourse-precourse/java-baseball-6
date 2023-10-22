package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

/**
 * 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 생성하는 클래스이다.
 */
public class NumberGenerator {
    public static final Integer MIN_RANDOM_NUMBER = 1;
    public static final Integer MAX_RANDOM_NUMBER = 9;
    
    public List<Integer> getUniqueRandomNumbers(int createLength) {
        Set<Integer> randomNumbers = new HashSet<>();

        while(randomNumbers.size() < createLength) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            randomNumbers.add(randomNumber);
        }

        return new ArrayList<>(randomNumbers);
    }
}
