package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InitNumber {
    public final String getInitNumber() {
        return IntStream.generate(() -> Randoms.pickNumberInRange(1, 9))
                .distinct()
                .limit(3)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
    }
}
