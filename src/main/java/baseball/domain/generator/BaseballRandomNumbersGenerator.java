package baseball.domain.generator;

import baseball.domain.Baseball;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.IntStream;

public class BaseballRandomNumbersGenerator implements BaseballNumbersGenerator {

    @Override
    public List<Integer> generate() {
        return IntStream.generate(() -> Randoms.pickNumberInRange(Baseball.MIN_NUMBER, Baseball.MAX_NUMBER))
                .distinct()
                .limit(Baseball.NUMBERS_COUNT)
                .boxed()
                .toList();
    }
}
