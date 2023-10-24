package baseball.domain.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BaseballRandomNumberGenerator implements RandomNumberGenerator<Integer,String> {

    private static final int START_INDEX = 0;
    private static final int NUMBER_COUNT = 3;
    @Override
    public Integer generate() {
        return Randoms.pickNumberInRange(1, 9);
    }

    @Override
    public String generateRandomNumbers() {
        return IntStream.range(START_INDEX, NUMBER_COUNT)
                .mapToObj(i -> String.valueOf(generate()))
                .collect(Collectors.joining());
    }
}
