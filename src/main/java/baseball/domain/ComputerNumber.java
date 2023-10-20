package baseball.domain;

import baseball.constant.Constant;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ComputerNumber {

    private static List<Integer> pickRandomNumber() {
        return Arrays.stream(new List[Constant.NUMBER_LENGTH_LIMIT])
                .map(num -> Randoms.pickNumberInRange(Constant.START_NUMBER, Constant.END_NUMBER))
                .collect(Collectors.toList());
    }

}
