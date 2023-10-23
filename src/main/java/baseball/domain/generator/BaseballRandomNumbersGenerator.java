package baseball.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.IntStream;

public class BaseballRandomNumbersGenerator implements BaseballNumbersGenerator {

    @Override
    public List<Integer> generate() {
        return IntStream.generate(() -> Randoms.pickNumberInRange(1, 9))
                .distinct()
                .limit(3)
                .boxed()
                .toList();
    }
}
