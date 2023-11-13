package baseball.number;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberProducer {

    /**
     * 범위 내 숫자 생성
     * @param startRangeNumber
     * @param endRangeNumber
     * @param count
     * @return
     */
    public static List<Integer> makeNumberInRange(
            int startRangeNumber,
            int endRangeNumber,
            int count
    ) {
        Set<Integer> computerSet = new HashSet<>();
        while (computerSet.size() < count) {
            computerSet.add(Randoms.pickNumberInRange(startRangeNumber, endRangeNumber));
        }
        List<Integer> computer = new ArrayList<>(computerSet);
        return computer;
    }

}
