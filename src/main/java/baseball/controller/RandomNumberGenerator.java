package baseball.controller;

import static java.util.stream.Collectors.toList;

import baseball.domain.BallNumber;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class RandomNumberGenerator {
    static public BallNumber generate() {
        ArrayList<Integer> computer = (ArrayList<Integer>) IntStream.generate(() -> Randoms.pickNumberInRange(1, 9))
                .distinct()
                .limit(3)
                .boxed()
                .collect(toList());
        return new BallNumber(computer);
    }
}
