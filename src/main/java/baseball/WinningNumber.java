package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningNumber {

    List<Integer> winningNumber;

    public WinningNumber() {
        this.winningNumber = Stream.generate(() -> Randoms.pickNumberInRange(1, 9))
                .distinct()
                .limit(3)
                .collect(Collectors.toList());
    }

}
