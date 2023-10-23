package baseball.controller;

import static java.util.stream.Collectors.toList;

import baseball.domain.BallNumber;
import baseball.system.SystemConstant;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.IntStream;

class RandomNumberGenerator {
    static BallNumber generate() {
        return new BallNumber(IntStream
                .generate(() ->
                        Randoms.pickNumberInRange(1, 9))
                .distinct()
                .limit(SystemConstant.MAXIMUM_DIGIT)
                .boxed()
                .collect(toList()));
    }
}
