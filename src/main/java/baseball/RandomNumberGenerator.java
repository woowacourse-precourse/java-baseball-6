package baseball;

import baseball.domain.BallNumber;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class RandomNumberGenerator {
    static public BallNumber generate() {
        ArrayList<Integer> computer = new ArrayList<>();
        IntStream.rangeClosed(1, SystemConstant.MAXIMUM_DIGIT)
                 .mapToObj(i -> Randoms.pickNumberInRange(1, 9))
                 .distinct()
                 .forEach(computer::add);
        return new BallNumber(computer);
    }
}
