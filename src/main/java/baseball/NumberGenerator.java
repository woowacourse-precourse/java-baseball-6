package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Stream;

public class NumberGenerator {
    private final int RANDOM_NUMBER_SIZE = 3;

    public List<Integer> generateNumber(){
        return Stream
                .generate(() -> Randoms.pickNumberInRange(1, 9))
                .distinct()
                .limit(RANDOM_NUMBER_SIZE)
                .toList();
    }

}
