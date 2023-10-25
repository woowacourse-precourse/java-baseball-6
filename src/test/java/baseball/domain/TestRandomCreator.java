package baseball.domain;

import static baseball.domain.SystemRandomCreator.MAX_NUMBER;
import static baseball.domain.SystemRandomCreator.MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;

public class TestRandomCreator implements RandomCreator {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;

    @Override
    public int createRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    @Override
    public List<Integer> createRandomNumbers() {
        return Arrays.asList(1, 2, 3);
    }
}
