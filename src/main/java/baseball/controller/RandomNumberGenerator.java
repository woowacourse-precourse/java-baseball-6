package baseball.controller;

import static java.util.stream.Collectors.toList;

import baseball.system.SystemConstant;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;

class RandomNumberGenerator {
    static List<Integer> generate() {
        return IntStream
                .generate(() ->
                        Randoms.pickNumberInRange(SystemConstant.MIN_NUMBER_EACH_DIGIT,
                                SystemConstant.MAX_NUMBER_EACH_DIGIT))
                .distinct()
                .limit(SystemConstant.DIGIT_SIZE)
                .boxed()
                .collect(toList());
    }
}
