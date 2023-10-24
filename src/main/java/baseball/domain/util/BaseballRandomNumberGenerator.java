package baseball.domain.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BaseballRandomNumberGenerator implements RandomNumberGenerator<Integer,String> {
    @Override
    public Integer generate() {
        return Randoms.pickNumberInRange(1, 9);
    }

    @Override
    public String generateRandomNumbers() {
        return IntStream.range(0, 3)
                .mapToObj(i -> String.valueOf(generate()))
                .collect(Collectors.joining());
    }
}
